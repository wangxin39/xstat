package org.xsaas.xstat.util;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FileUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.xsaas.xstat.conf.Common;

import magick.CompressionType;
import magick.ImageInfo;
import magick.MagickException;
import magick.MagickImage;
import magick.PreviewType;

public class ImageUtil {
	static {
		System.setProperty("jmagick.systemclassloader", "no");
	}
	private static final Logger log = LoggerFactory.getLogger(ImageUtil.class);
	private int width = 1;
	private int height = 1;
	private ImageInfo info;
	public final static byte IMG_SQUARE = 0;
	public final static byte IMG_OBLONG = 1;

	public ImageUtil(int width, int height, String source) {
		try {
			info = new ImageInfo(source);
			info.setCompression(CompressionType.JPEGCompression);
			info.setPreviewType(PreviewType.JPEGPreview);
			this.width = width;
			this.height = height;
		} catch (MagickException e) {
			log.error(e.getMessage(), e);
		}
	}

	/*****
	 * 按照尺寸切图
	 * 
	 * @param newFileName
	 * @param w
	 * @param h
	 */
	public void makePic(String newFileName, int w, int h) {
		try {
			info.setQuality(90);
			MagickImage image = new MagickImage(info);
			image.profileImage("*", null);
			MagickImage scaled = null;

			if (width < w && height < h) {
				scaled = image.scaleImage(width, height);
			} else {
				if (width < w && height > h)
					scaled = image.scaleImage(width, h);
				else if (width > w && height < h)
					scaled = image.scaleImage(w, height);
				else
					scaled = image.scaleImage(w, h);
			}

			scaled = scaled.sharpenImage(1.0, 5.0);
			scaled.setFileName(newFileName);
			scaled.writeImage(info);
		} catch (MagickException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void makeSmall(String newFileName, int size) {
		try {
			info.setQuality(90);
			MagickImage image = new MagickImage(info);
			image.profileImage("*", null);
			MagickImage scaled = null;
			double proportion = 0;
			if (width < size && height < size) {
				scaled = image.scaleImage(width, height);
			} else {
				if (width == height) {
					scaled = image.scaleImage(size, size);
				} else {
					if (width > height) {
						if (width > size) {
							proportion = (double) size / width;
						} else {
							proportion = width / (double) size;
						}
						scaled = image.scaleImage(size,
								(int) (height * proportion));
					} else {
						if (height > size) {
							proportion = (double) size / height;
						} else {
							proportion = height / (double) size;
						}
						scaled = image.scaleImage((int) (width * proportion),
								size);
					}
				}
			}
			scaled = scaled.sharpenImage(1.0, 5.0);
			scaled.setFileName(newFileName);
			scaled.writeImage(info);
		} catch (MagickException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void makeBig(String newFileName, int size) {
		try {
			info.setQuality(90);
			MagickImage image = new MagickImage(info);
			image.profileImage("*", null);
			MagickImage scaled = null;
			double proportion = 0;
			if (width == height) {
				if (width > size) {
					proportion = (double) size / width;
					scaled = image.scaleImage((int) (width * proportion),
							(int) (width * proportion));
				} else {
					scaled = image.scaleImage(width, height);
				}
			} else {
				if (width > height) {
					if (width > size) {
						proportion = (double) size / width;
						scaled = image.scaleImage(size,
								(int) (height * proportion));
					} else {
						scaled = image.scaleImage(width, height);
					}
				} else {
					if (height > size) {
						proportion = (double) size / height;
						scaled = image.scaleImage((int) (width * proportion),
								size);
					} else {
						scaled = image.scaleImage(width, height);
					}
				}
			}
			if (size > 800) {
				scaled = scaled.sharpenImage(1.0, 1.0);
			} else {
				scaled = scaled.sharpenImage(1.0, 5.0);
			}
			scaled.setFileName(newFileName);
			scaled.writeImage(info);
		} catch (MagickException e) {
			log.error(e.getMessage(), e);
		}
	}

	public void makeSquare(String newFileName, int size) throws Exception {
		Rectangle rect = null;
		if (width < size && height < size) {
			rect = new Rectangle(0, 0, size, size);
		} else if (width < size || height < size) {
			rect = new Rectangle(0, 0, size, size);
		} else {
			if (width < height) {
				int beginPoint = (height - width) / 2;
				rect = new Rectangle(0, beginPoint, width, width);
			} else {
				int beginPoint = (width - height) / 2;
				rect = new Rectangle(beginPoint, 0, height, height);
			}
		}
		info.setQuality(85);
		MagickImage image = new MagickImage(info);
		image.profileImage("*", null);
		MagickImage cropped = image.cropImage(rect).scaleImage(size, size);
		cropped = cropped.sharpenImage(1.0, 5.0);
		cropped.setFileName(newFileName);
		cropped.writeImage(info);
	}

	public void makeImage(String newFile, byte type, int size) throws Exception {
		if (type == ImageUtil.IMG_SQUARE) {
			this.makeSquare(newFile, size);
		} else if (type == ImageUtil.IMG_OBLONG) {
			if (size <= 120) {
				this.makeSmall(newFile, size);
			} else if (size > 120) {
				this.makeBig(newFile, size);
			}
		}
	}

	public static Map<String, Object> getImageInfo(Object input)
			throws Exception {
		ImageInputStream iis = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			iis = ImageIO.createImageInputStream(input);
			Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
			if (readers.hasNext()) {
				ImageReader reader = readers.next();
				reader.setInput(iis);
				String imgType = reader.getFormatName();
				if (imgType.equalsIgnoreCase("JPEG")
						|| (imgType.equalsIgnoreCase("gif"))
						|| imgType.equalsIgnoreCase("png")) {
					int width = reader.getWidth(0);
					int height = reader.getHeight(0);
					map.put("width", width);
					map.put("height", height);
					if (iis != null) {
						iis.close();
						iis = null;
					}
				}
			}
			return map;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new Exception(e);
		} finally {
			if (iis != null) {
				iis.close();
				iis = null;
			}
		}
	}

	/**
	 * 图片上传压缩
	 * 
	 * @param cid
	 *            平台用户 id
	 * @param file
	 *            上传的图片文件
	 * @param no1_path
	 *            小图路径+名称
	 * @param no2_path
	 *            中图路径+名称
	 * @param no3_path
	 *            大图路径+名称
	 * @param picDefault
	 *            默认图片
	 * @param picPath
	 *            图片路径
	 * @throws Exception
	 */
	public static void CutPic(int cid, File file, String no1_path,
			String no2_path, String no3_path, String picPath) throws Exception {

		File f = new File(picPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		Map<String, Object> map = ImageUtil.getImageInfo(file);
		int width = (Integer) map.get("width");
		int heigth = (Integer) map.get("height");
		ImageUtil iu = new ImageUtil(width, heigth, file.getAbsolutePath());
		if (width / heigth >= 4 / 3) {
			iu.makePic(no1_path, 120, (heigth * 120) / width);
			iu.makePic(no2_path, 320, (heigth * 320) / width);
		} else {
			iu.makePic(no1_path, (width * 90) / heigth, 90);
			iu.makePic(no2_path, (width * 240) / heigth, 240);
		}
		iu.makePic(no3_path, width, heigth);
	}

	/***
	 * @param file
	 * @param no1_path
	 * @param picPath
	 * @param needwidth
	 * @param needheight
	 * @param needType
	 * @throws Exception
	 */
	public static void CutPicForYhqLeft(File file, String no1_path,
			String picPath, int needwidth, int needheight, int needType)
			throws Exception {
		File f = new File(picPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		Map<String, Object> map = ImageUtil.getImageInfo(file);
		int width = (Integer) map.get("width");
		int heigth = (Integer) map.get("height");
		ImageUtil iu = new ImageUtil(width, heigth, file.getAbsolutePath());
		if (needType == 1) {
			if (width / heigth >= 5 / 3) {
				iu.makePic(no1_path, needwidth, (heigth * needwidth) / width);
			} else {
				iu.makePic(no1_path, (width * needheight) / heigth, needheight);
			}
		} else {
			iu.makePic(no1_path, needwidth, needheight);
		}
	}

	public static void CutPicForDefaultTjc(Integer clientid, String picname,
			Long tjcId) {
		String path = ImageUtil.getPathById(Common.IMAGE_HOME, clientid,
				"images");
		String def_name = "tjc_default_" + tjcId + ".jpg";
		picname += "_1.jpg";
		File old_file = new File(path + picname);
		File def_file = new File(path + def_name);
		try {
			FileUtils.copyFile(old_file, def_file);
		} catch (IOException e) {
			log.error("拷贝特价菜默认图失败", e);
		} catch (Exception e) {
			log.error("拷贝特价菜默认图失败", e);
		}

	}

	/***
	 * 剪切单张餐厅自传图片
	 * 
	 * @param cid
	 * @param file
	 * @param no1_path
	 * @param picPath
	 * @throws Exception
	 */
	public static void CutPicForYhqForlist(File file, int width_1, int height_1)
			throws Exception {
		Map<String, Object> map = ImageUtil.getImageInfo(file);
		int width = (Integer) map.get("width");
		int heigth = (Integer) map.get("height");
		ImageUtil iu = new ImageUtil(width, heigth, file.getAbsolutePath());
		iu.makePic(file.getAbsolutePath(), width_1, height_1);
	}

	/**
	 * 根据id生成完整路径,并在文件系统中生成这些文件夹
	 * 
	 * @param prePath
	 * @param id
	 * @return
	 */
	public static String getPathById(String prePath, int id) {
		/**
		 * 根据餐厅id按照3位来分割
		 */
		String strId = Integer.toString(id);
		int iPost = (3 < strId.length()) ? 3 : strId.length();
		int kk = 0;
		StringBuffer sbFileName = new StringBuffer();
		while (iPost <= strId.length()) {
			sbFileName.append(strId.substring(kk, iPost));
			sbFileName.append(File.separatorChar);
			kk = iPost;

			iPost += 3;
			iPost = (iPost < strId.length()) ? iPost : strId.length();
			if (kk == iPost) {
				break;
			}
		}
		String filePath = prePath + sbFileName.toString();
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		return filePath;
	}

	/**
	 * 根据id生成完整路径,并在文件系统中生成这些文件夹
	 * 
	 * @param prePath
	 * @param footPath
	 * @param id
	 * @return
	 */
	public static String getPathById(String prePath, int id, String footPath) {
		String strId = Integer.toString(id);
		int iPost = (3 < strId.length()) ? 3 : strId.length();
		int kk = 0;
		StringBuffer sbFileName = new StringBuffer();
		while (iPost <= strId.length()) {
			sbFileName.append(strId.substring(kk, iPost));
			sbFileName.append("/");
			kk = iPost;

			iPost += 3;
			iPost = (iPost < strId.length()) ? iPost : strId.length();
			if (kk == iPost) {
				break;
			}
		}
		String filePath = prePath + sbFileName.toString() + footPath + "/";
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		return filePath;
	}
}