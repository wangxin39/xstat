
drop database if exists webstatdb;
create database webstatdb  default character set utf8;

grant all privileges on webstatdb.* to webstat@localhost identified by '123456' with grant option;

use webstatdb;


DROP TABLE IF EXISTS activemq_acks;
CREATE TABLE activemq_acks (
  CONTAINER varchar(250) NOT NULL,
  SUB_DEST varchar(250) DEFAULT NULL,
  CLIENT_ID varchar(250) NOT NULL,
  SUB_NAME varchar(250) NOT NULL,
  SELECTOR varchar(250) DEFAULT NULL,
  LAST_ACKED_ID int(11) DEFAULT NULL,
  PRIMARY KEY (CONTAINER,CLIENT_ID,SUB_NAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS activemq_lock;
CREATE TABLE activemq_lock (
  ID bigint(20) NOT NULL,
  TIME bigint(20) DEFAULT NULL,
  BROKER_NAME varchar(250) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS activemq_msgs;
CREATE TABLE activemq_msgs (
  ID int(11) NOT NULL,
  CONTAINER varchar(250) DEFAULT NULL,
  MSGID_PROD varchar(250) DEFAULT NULL,
  MSGID_SEQ int(11) DEFAULT NULL,
  EXPIRATION bigint(20) DEFAULT NULL,
  MSG longblob,
  PRIMARY KEY (ID),
  KEY ACTIVEMQ_MSGS_MIDX (MSGID_PROD,MSGID_SEQ),
  KEY ACTIVEMQ_MSGS_CIDX (CONTAINER),
  KEY ACTIVEMQ_MSGS_EIDX (EXPIRATION)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists smgk_info;
create table smgk_info
(
	smgkid                int(11) not null auto_increment,
	username              varchar(255),
	password              varchar(20),
	cityid                int(11),
	province              int(11),
	realname              varchar(255),
	telephone             varchar(255),
	mobile                varchar(255),
	birthday              varchar(255),
	sex                   varchar(255),
	nation                int(11),
	marriage              varchar(255),
	stature               varchar(255),
	avoirdupois           varchar(255),
	education             int(11),
	speciality            varchar(255),
	vocation              varchar(255),
	job                   varchar(255),
	company               varchar(255),
	postcode              varchar(255),
	QQ                    varchar(255),
	MSN                   varchar(255),
	address               varchar(255),
	edu                   varchar(255),
	interest              varchar(255),
	device                varchar(255),
	possession            varchar(255),
	bank                  varchar(255),
	bankid                varchar(255),
	bankusername          varchar(255),
	status                smallint(2) default 1,               
	regtime               datetime, 
	code                  varchar(255),
	idnumber              varchar(255),
	idfilename            varchar(255),
	filetype              smallint(2),
	authstatus            smallint(2),
	regstatus             smallint(2),
	primary key (smgkid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists article_info;
create table article_info
(
	articleid             int(11) not null auto_increment,
	title                 varchar(255),
	content               text,
	author                varchar(255),
	source                varchar(255),
	status                smallint(2) default 1,
	addtime               datetime,
	primary key (articleid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists publish_info;
create table publish_info
(
	publishid             int(11) not null auto_increment,
	type                  smallint(2),
	articleid             int(11) not null,
	smgkid                int(11) not null,
	status                smallint(2) default 1,
	publishtime           datetime,
	primary key (publishid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists client_info;
create table client_info
(
	clientid              int(11) NOT NULL auto_increment,
	company               varchar(255),
	encompany             varchar(255),
	description           varchar(255),	
	status                smallint(2) default 1,    
	primary key (clientid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists informant_info;
create table informant_info
(
	informantid           int(11) not null auto_increment,
	clientid			  int(11) not null,
	name                  varchar(255),
	englishName           varchar(255),
	aliasName             varchar(255),
	englishAliasName      varchar(255),
	country                  varchar(255) not null,
	province				 smallint(2),	
	cityid                   int(11) not null,
	telephone				 varchar(255),	
	mobile				     varchar(255),	
	email                    varchar(255) not null,
	address				     varchar(255),	
	postcode				 varchar(255),	
	servicetime			     datetime,
	servicelang				 varchar(255),
	servicetype				 varchar(255),	
	area     				 varchar(255),
	status                smallint(2) default 1,
	primary key (informantid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists project_info;
create table project_info
(
	projectid             int(11) not null auto_increment,
	clientid              int(11) not null,
	name                  varchar(255),
	englishname           varchar(255),
	description           varchar(255),
	status                smallint(2) default 1,
	primary key (projectid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists issue_info;
create table issue_info
(
	issueid             int(11) not null auto_increment,
	projectid           int(11) not null,
	clientid						int(11) not null,
	issue               varchar(255),
	startday						varchar(255),
	endday							varchar(255),
	startTime						varchar(255),
	endtime							varchar(255),
	checktime						datetime,
	year								int,
	isfirst							smallint(2) default 2,	
	inquisitionid       int(11) not null,
	actions             smallint(2),
	chartstatus        smallint(2),
	evaluationstatus    smallint(2),
	statstatus          smallint(2),
	reportstatus        smallint(2),
	addtime             datetime,	
	status              smallint(2)  default 1,    
	primary key (issueid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists client_account_info;
create table client_account_info
(
	accountID                int(11) not null auto_increment,
	clientid                 int(11) not null,
	type									smallint(2) default 1,
	informantid			     int(11) not null,
	clientname				 varchar(255),
	loginName                varchar(255) not null,		
	password				 varchar(255),	
	country                  varchar(255) not null,
	province				 smallint(2),	
	cityid                   int(11) not null,
	telephone				 varchar(255),	
	mobile				     varchar(255),
 	lastlogin			     datetime,
 	lastip				     varchar(255),
 	fatherid                 int(11) default 0,	
 	status                   smallint(2)  default 1,    
	primary key (accountid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists video_info;
create table video_info
(
	videoid             int(11) not null auto_increment,
	clientid            int(11) not null,
	informantid			int(11) not null,
	name                varchar(255),
	englishname         varchar(255),
	url                 varchar(255),
	status              smallint(2) default 1,
	addtime             datetime,
	primary key (videoid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists option_info;
create table option_info
(
	optionid              int(11) not null auto_increment,
	type									smallint(2) default 1,
	chinaoption       		      varchar(255),
 	englishoption	      	varchar(255),	
	status                smallint(2) default 1,    
	primary key (optionid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists option_template_info;
create table option_template_info(
	optiontemplateid 		int(11) not null auto_increment,
	title varchar(255),
	description varchar(255),
	status smallint(2) default 1,
	primary key (optiontemplateid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists option_relation_info;
create table option_relation_info(
	optionrelationid	int(11) not null auto_increment,
	optiontemplateid	int(11),
	shownum varchar(255),
	OptionName varchar(255),
	alterID	int(11),
	optionID int(11),
	status smallint(2),
	primary key(optionrelationid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists question_info;
create table question_info
(
	questionid         int(11) not null auto_increment,
	questiontype       smallint(2),
	question           text,
	englishquestion    text,
	zhexplain          text,
	englishexplain     text,
	FieldType		   smallint(2),	
	FieldValue         varchar(255),
	format			   varchar(255),
	status             smallint(2)  default 1,    
	primary key (questionid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists resource_info;
create table resource_info
(
	resourceid         int(11) not null auto_increment,
	filename           varchar(255),
	fileType           smallint(2),
	savepath           varchar(255),
	uploadtime         datetime,
	status             smallint(2)  default 1,
	primary key (resourceid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists Inquisition_header_info;
create table Inquisition_header_info
(
	headerid               int(11) not null auto_increment,
	inquisitionid          int(11) not null,
	questionid             int(11) not null,
	questiontype           smallint(2),	
	isinput                smallint(2),
	ShowOrder              smallint(2),
	fieldName			   varchar(255),	
	selecttype						smallint(2) default 0,
	optiontemplateid			int(11) default 0,
	status                 smallint(2)  default 1,    
	primary key (headerid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists Inquisition_header_select_info;
create table Inquisition_header_select_info
(
	headerSelectID          int(11) not null auto_increment,
	inquisitionid           int(11) not null,
	headerid                int(11) not null,	
	alterid	                int(11) not null,
	optionid  	            int(11) not null,
	shownum									varchar(255),
	showOrder						    smallint(2),
	fieldName								varchar(255),
	status                  smallint(2)  default 1,    	
	primary key (headerSelectID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists part_info;
create table part_info
(
	partid               int(11) not null auto_increment,
	inquisitionid        int(11) not null,
	shownum              varchar(255),
	showorder            smallint(2),
	name                 varchar(255),
	englishname          varchar(255),	
	status               smallint(2)  default 1,    
	primary key (partid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists part_question_info;
create table part_question_info
(
	partquestionid        int(11) not null auto_increment,
	inquisitionid         int(11) not null,
	partid                int(11) not null,
	questionid            int(11) not null,
	questiontype		  smallint(2),
	shownum               smallint(2),
	fieldname			  varchar(255),
	fatherpqid            int(11),
	validation            smallint(2),
	selecttype						smallint(2) default 0,
	optiontemplateid			int(11) default 0,
	status                smallint(2) default 1,    
	primary key (partquestionid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists part_select_info;
create table part_select_info
(
	partSelectID          int(11) not null auto_increment,
	inquisitionid         int(11) not null,
	partquestionid        int(11) not null,	
	AlterID			      		int(11) not null,
	optiontype						smallint(2) default 1,
	optionid  	          int(11) not null,
	shownum								varchar(255),	
	showOrder			  			smallint(2),
	comment				  			text,
	englishComment	      text,	
	status                smallint(2) default 1,    				
	primary key (partSelectID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists inquisition_template_info;
create table inquisition_template_info
(
	templateid             int(11) not null auto_increment,
	name                   varchar(255),
	Description            varchar(255),
	Filename               varchar(255),
	fileType               smallint(2),
	Savepath               varchar(255),
	status                 smallint(2)  default 1,
	primary key (templateid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists inquisition_info;
create table inquisition_info
(
	inquisitionid       int(11) not null auto_increment,
	clientid            int(11) not null,
	templateid          int(11) not null,
	title               varchar(255),
	status              smallint(2)  default 1,
	inquisitionstatus   smallint(2) default 1,
	primary key (inquisitionid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists plan_info;
create table plan_info
(
	planid             int(11) not null auto_increment,
	name               varchar(255),
	issueid            int(11) not null,
	round             smallint(2),
	clientid		   		int(11) not null,
	projectid          int(11) not null,
	smgkid             int(11) not null,
	informantid        int(11) not null,
	jobid    		   		 varchar(255) not null,
	startday           datetime,
	endday             datetime,
	starttime          varchar(255),
	endtime            varchar(255),
	weightPattern      smallint(2) default 1, 
	plantype					 smallint(2) default 1,  
	checkstatus        smallint(2) default 1,
	chartstatus        smallint(2) default 1,
	evaluationstatus    smallint(2) default 1,
	statstatus          smallint(2) default 1,
	reportstatus        smallint(2) default 1,
	status             smallint(2)  default 1,
	primary key (planid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists grade_relation_info;
create table grade_relation_info(
	graderelationid int(11) not null auto_increment,
	clientid int(11) not null,
	issueid int(11) not null,
	informantid int(11),
	GradeStdID int(11) not null,
	status smallint(2) not null default 1,
	primary key(graderelationid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists grade_std_info;
create table grade_std_info(
	gradestdid int(11) not null auto_increment,
	inquisitionid int(11) not null,
	title varchar(255) not null,
	description varchar(255),
	status smallint(2) not null default 1,
	primary key(gradestdid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists grade_std_relation_info;
create table grade_std_relation_info(
	stdrelationid int(11) not null auto_increment,
	gradestdid int(11),
	selectweightid int(11),
	status smallint(2) not null default 1,
	primary key(stdrelationid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists select_weight_info;
create table select_weight_info
(
	selectWeightID        int(11) not null auto_increment,
	inquisitionid         int(11) not null,
	partid				  			int(11) not null,
	partQuestionid        int(11) not null,	
	optionrelationid			int(11),
	PartSelectID          int(11),
	weight      		  		smallint(2) default 0,
	status                smallint(2) default 1,    
	primary key (selectWeightID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists header_record_info;
create table header_record_info
(
	headerrecordID        int(11) not null auto_increment,
	planid                int(11) not null,
	issueid               int(11) not null,
	round                 smallint(2),
	clientid              int(11) not null,
	informantid           int(11) not null,
	smgkid                int(11) not null,
	inquisitionid         int(11) not null,
	headerid              int(11) not null,
	questionType      	  smallint(2),
	optionrelationid			int(11),
	PartSelectID          int(11),
	fieldname			  varchar(255) not null,
	answer                text,
	enanswer				text,
	addtime				  datetime,	
	primary key (headerrecordID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists part_record_info;
create table part_record_info
(
	partrecordID          int(11) not null auto_increment,
	planid                int(11) not null,
	issueid               int(11) not null,
	round                 smallint(2),
	clientid              int(11) not null,
	informantid           int(11) not null,
	smgkid                int(11) not null,
	inquisitionid         int(11) not null,
	partid                int(11) not null,
	partQuestionid        int(11) not null,
	weighted      		  smallint(2),
	questionType      	  smallint(2),
	optionrelationid					int(11),
	PartSelectID              int(11),
	fieldname			  varchar(255) not null,
	answer                text,
	enanswer				text,
	addtime				  datetime,	
	primary key (partrecordID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists stat_question_info;
create table stat_question_info
(
	statID                int(11) not null auto_increment,
	year                  int(11),
	month        		  		smallint(2),
	day             	  	smallint(2),
	checktime			  			datetime,	
	clientid              int(11) not null,
	projectid             int(11) not null,
	issueid               int(11) not null,
	round                 smallint(2),
	informantid           int(11) not null,
	smgkid                int(11) not null,
	inquisitionid         int(11) not null,
	weight      				  smallint(2),
	planid                int(11) not null,
	partid                int(11) not null,
	partQuestionid        int(11) not null,
	PartSelectID          int(11),
	optionrelationid			int(11),
	marks			     			  int(4) not null default 0,
	status                smallint(2) default 1,    
	primary key (statID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists stat_part_info;
create table stat_part_info
(
	StatPartID     int(11) not null auto_increment,
	month        		  smallint(2),
	day             	  smallint(2),
	year                  int(11),
	checktime			  datetime,	
	clientid              int(11) not null,
	projectid             int(11) not null,
	issueid               int(11) not null,
	round                 smallint(2),
	informantid           int(11) not null,
	smgkid                int(11) not null,
	inquisitionid         int(11) not null,
	planid         int(11) not null,
	partid         int(11) not null,
	weightedmark   int(4) default 0,
	actualmarks    int(4) default 0,
	percentage     double default 0.0,
	status         smallint(2)  default 1,    
	primary key (statpartID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists inquisition_mark_info;
create table inquisition_mark_info
(
	inquisitionmarkID     int(11) not null auto_increment,
	year                  int(11),
	month        		  smallint(2),
	day             	  smallint(2),
	checktime			  datetime,	
	clientid              int(11) not null,
	projectid             int(11) not null,
	issueid               int(11) not null,
	informantid           int(11) not null,
	smgkid                int(11) not null,
	inquisitionid					int(11) not null,
	weightmarkround1      smallint(2),	
	actualmarkRound1	  smallint(2),
	scoremarkround1       double(8,2),
	weightmarkround2      smallint(2),
	actualmarkRound2	  smallint(2),
	scoremarkround2       double(8,2),
	average               double(8,2),
	primary key (inquisitionmarkID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists stat_chart_info;
create table stat_chart_info
(
    chartID                int(11) not null auto_increment,
    month        		  smallint(2),
	day             	  smallint(2),
	year                  int(11),
	checktime			  datetime,	
	clientid              int(11) not null,
	projectid             int(11) not null,
	issueid               int(11) not null,
	informantid           int(11) not null,
	smgkid                int(11) not null,
    type           		   smallint(2),
    filename			   varchar(255),
    savepath			   varchar(255), 
	primary key (chartID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists informant_evaluation_info;
create table informant_evaluation_info
(
	evaluationID            int(11) not null auto_increment,
	month        		  smallint(2),
	day             	  smallint(2),
	year                  int(11),
	checktime			  datetime,	
	clientid              int(11) not null,
	projectid             int(11) not null,
	issueid               int(11) not null,
	informantid           int(11) not null,
	partid                int(11) not null,
	evaluation       smallint(2),
	primary key (evaluationID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists final_evaluation_info;
create table final_evaluation_info
(
	finalevaluationID     int(11) not null auto_increment,
	month        		  smallint(2),
	day             	  smallint(2),
	year                  int(11),
	checktime			  datetime,	
	clientid              int(11) not null,
	projectid             int(11) not null,
	issueid               int(11) not null,	
	passnum               smallint(2),
	failnum            		smallint(2),
	informantnum	    		smallint(2),
	average				        double(8,2),
	primary key (finalevaluationID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists remark_info;
create table remark_info
(
	remarkid              int(11) not null auto_increment,
	clientid              int(11) not null, 
	projectid              int(11) not null, 
	employeeid            int(11) not null,
	informantid           int(11) not null,
 	issueid               int(11) not null,
	inquisitionid         int(11) not null,
	partid                int(11) not null,
	strengths             text,
	enstrengths           text,
	weaknesses            text,
	enweaknesses          text,
	conclusion            text,
	enconclusion          text,
	addtime               datetime,
	status 			      smallint(2)  default 1,
	remarkStatus          smallint(2),
	primary key (remarkid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;



drop table if exists reality_check_info;
create table reality_check_info
(
	realitycheckid             int(11) not null auto_increment,
	clientid              int(11) not null,
	projectid             int(11) not null,
	issueid               int(11) not null,
	inquisitionid              int(11) not null,
    thisTime                   text,
    enThisTime                 text,
    sofartime                  text,
    ensofartime                text,
	markreal				   text,     
 	enmarkreal                 text,
	addtime                    datetime,
	status                     smallint(2)  default 1,    
	primary key (realitycheckid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists check_detail_info;
create table check_detail_info
(
	checkdetailid              int(11) not null auto_increment,
	clientid              int(11) not null,
	projectid             int(11) not null,
	issueid               int(11) not null,
	inquisitionid              int(11) not null,
    what                       text,
    enwhat                     text,
    type                       smallint(2),   
	status                     smallint(2)  default 1,    
	primary key (checkdetailid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists report_info;
create table report_info
(
	reportid                  int(11) not null auto_increment,
	themeid                   int(11) not null,
	issueid                   int(11) not null,
	informantid               int(11) not null,
	checkName                 varchar(255),
	reporttitle               varchar(255),
	enreporttitle             varchar(255),
	quartertitle              varchar(255),
	pageCount                 smallint(2),
	reporttype                smallint(2),
	addtime                   datetime,
	status                    smallint(2)  default 1,    
	primary key (reportid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists theme_info;
create table theme_info
(
    themeid                   int(11) not null auto_increment,
	description               varchar(255),
	title                     varchar(255),
	status                    smallint(2)  default 1,    
	primary key (themeid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists theme_style_info;
create table theme_style_info
(
	styleid                   int(11) not null auto_increment,
	themeid                   int(11) not null,
	reporttemplateid          int(11) not null,
	pagenum                   smallint(2),
	stattype                  smallint(2),
	statchart                 varchar(255),
	title                     varchar(255),
	content                   varchar(255),
	isbackimage               smallint(2),
	imagename                 varchar(255),
	savepath                  varchar(255),
	status                    smallint(2)  default 1,    
	primary key (styleid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists report_template_info;
create table report_template_info
(
	reporttemplateid       int(11) not null auto_increment,
	name                   varchar(255),
	Description            varchar(255),
	Filename               varchar(255),
	path                   varchar(255),
	addtime                datetime,
	status                 smallint(2)  default 1,
	type                   smallint(2),
	primary key (reporttemplateid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists output_info;
create table output_info
(
	outputid                  int(11) not null auto_increment,
	clientid                  int(11) not null,
	issueid                   int(11) not null,
	informantid               int(11) not null,
	filetype                  smallint(2),
	filename                  varchar(255),
	savepath                  varchar(255),
	maketime                  datetime,
	status                    smallint(2)  default 1,    
	primary key (outputid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists client_popedom_info;
create table client_popedom_info
(
	clientpopedomID         int(11) not null auto_increment,
	popedom                 smallint(2),
	clientid                int(11) not null,
	planid                  int(11) not null,
	issueid                 int(11) not null,
	accountid               int(11) not null,
	status                 smallint(2)  default 1,    
	primary key (clientpopedomID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists site_popedom_info;
create table site_popedom_info
(
	sitepopedomID             int(11) not null auto_increment,
	popedom                   smallint(2),
	employeeid                int(11) not null,
	status                    smallint(2)  default 1,    
	primary key (sitepopedomID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists req_info;
create table req_info
(
	reqid                 int(11) not null auto_increment,
	accountid              int(11) not null,
	employeeid            int(11) not null,
	description           text,
	name                  varchar(255),
	email                 varchar(255),
	telephone             varchar(255),
	reqtime               datetime,
	status                smallint(2) default 1,
	reqstatus             smallint(2),
	primary key (reqid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists req_result_info;
create table req_result_info
(
	resultid              int(11) not null auto_increment,
	accountid              int(11) not null,
	employeeid            int(11) not null,
	reqid                 int(11) not null,
	title                 varchar(255),
	content               varchar(255),
	reqtime               datetime,
	status                smallint(2) default 1,    
	primary key (resultid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists city_info;
create table city_info
(
	cityid                int(11) not null auto_increment,
	name                  varchar(255),
	province              int(11),
	englishname           varchar(255),
	status                smallint(2) default 1,    
	primary key (cityid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists smgk_menu_info;
create table smgk_menu_info
(
	menuid                int(11) not null auto_increment,
	menu                  varchar(255),
	url                   varchar(255),
	primary key (menuid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists menu_info;
create table menu_info
(
	menuid                int(11) not null auto_increment,
	menu                  varchar(255),
	type                  smallint(2),
	parentid              int(11) default 0,
	url                   varchar(255),
	status                smallint(2) default 1,    
	primary key (menuid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists employee_info;
create table employee_info
(
	EmployeeID            int(11) not null auto_increment,
	name                  varchar(255),
	sex                   varchar(50),
	depart                varchar(255),
	job                   varchar(255),
	loginname             varchar(255),
	password              varchar(255),
	description           varchar(255),
	status                smallint(2) default 1,
	addtime               datetime,
	primary key (EmployeeID)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists email_draft_info;
create table email_draft_info
(
	draftid               int(11) not null auto_increment,
	acID                  int(11) not null,
	addressid             int(11) not null,
	EmployeeID            int(11) not null,
	sendto                varchar(255),
	sendtime              datetime,
	att                   varchar(255),
	topic                 varchar(255),
	content               varchar(255),
	status                smallint(2) default 1,
	primary key (draftid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists email_send_info;
create table email_send_info
(
	sendid                int(11) not null auto_increment,
	acID                  int(11) not null,
	addressid             int(11) not null,
	EmployeeID            int(11) not null,
	sendto                varchar(255),
	sendtime              datetime,
	att                   varchar(255),
	topic                 varchar(255),
	content               varchar(255),
	status                smallint(2) default 1,
	primary key (sendid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists address_catalog_info;
create table address_catalog_info
(
	acid                  int(11) not null auto_increment,
	name                  varchar(255),
	country               varchar(255),
	lang                  varchar(255),
	status                smallint(2) default 1,    
	primary key (acid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists email_address_info;
create table email_address_info
(
	addressid             int(11) not null auto_increment,
	acid                  int(11) not null,
	cityid                int(11) not null,
	province			  smallint(2),
	name                  varchar(255),
	telephone             varchar(255),
	address               varchar(255),
	email                 varchar(255),
	QQ                    varchar(255),
	MSN                   varchar(255),
	mobile                varchar(255),
	job                   varchar(255),
	company               varchar(255),
	postcode              varchar(255),
	notes                 varchar(255),
	status                smallint(2) default 1,    
	primary key (addressid)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;



