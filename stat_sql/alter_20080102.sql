


alter table select_weight_info change selectid PartSelectID int(11) default 0;
alter table header_record_info change selectid HeaderSelectID int(11) default 0;
alter table part_record_info change selectid PartSelectID int(11) default 0;


alter table stat_question_info change selectid PartSelectID  int(11) default 0;



# 2009-01-02 新增
alter table plan_info modify JobID  varchar(255);


alter table header_record_info drop questionid;
alter table part_record_info drop questionid;

alter table question_select_info drop OptionValue;

alter table inquisition_header_select_info drop questionid;

alter table Inquisition_header_select_info drop OptionType;

drop table if exists Inquisition_header_select_info;
create table Inquisition_header_select_info
(
	headerSelectID          int(11) not null auto_increment,
	inquisitionid           int(11) not null,
	headerid                int(11) not null,	
	selectid                int(11) not null,
	optionid  	            int(11) not null,
	shownum									varchar(255),
	showOrder						    smallint(2),
	fieldName								varchar(255),
	status                  smallint(2)  default 1,    	
	primary key (headerSelectID)
 )ENGINE=InnoDB DEFAULT CHARSET=gbk;
 
 
drop table if exists part_select_info;
create table part_select_info
(
	partSelectID          int(11) not null auto_increment,
	inquisitionid         int(11) not null,
	partquestionid        int(11) not null,	
	SelectID		      		int(11) not null,
	optiontype						smallint(2) default 1,
	optionid  	          int(11) not null,
	shownum								varchar(255),	
	showOrder			  			smallint(2),
	comment				  			text,
	englishComment	      text,	
	status                smallint(2) default 1,    				
	primary key (partSelectID)
 )ENGINE=InnoDB DEFAULT CHARSET=gbk; 