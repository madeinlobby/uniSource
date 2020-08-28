/**
# =================================================================
Author:          <Ladies of the wood>
Create date:     <25 Aug 2020>
Description:     <University online source - Automation Online Source - System version>
# =================================================================
**/
use university_source;

create table `user`(
	user_id		int		not null	auto_increment	unique,
    username		varchar(100) charset utf8	not null unique,
	firstname	varchar(120) charset utf8	null,
	lastname		varchar(120) charset utf8	null,
    enabled		boolean		not null,
    `password`		varchar(128) charset utf8		not null,
	modification_date	timestamp	not null	default CURRENT_TIMESTAMP,
    constraint	PK_User_UserID	primary key(user_id)
);

create table role(
	role_id		int		not null	auto_increment	unique,
    `name`	enum('ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN')		not null,
    constraint	PK_Role_RoleID	primary key(role_id)
);

create table user_role(
	user_id		int		not null,
    role_id		int		not null,
    constraint FK_User_Role_UserID	foreign key(user_id)	references `user`(user_id) on update cascade on delete cascade,
    constraint FK_User_Role_RoleID	foreign key(role_id)	references role(role_id)	on update cascade on delete cascade,
    constraint PK_User_Role_UserID_RoleID		primary key(user_id, role_id)
);

create table course(
	course_id 	int		not null	auto_increment	unique,
    `name`		varchar(120) charset utf8	not null,
    course_code		varchar(50)	charset utf8	not null unique,
    modification_date	timestamp	not null	default CURRENT_TIMESTAMP,
    constraint	PK_Course_CourseID	primary key(course_id)
);

create table tag(
	tag_id	int		not null	auto_increment unique,
    `name`		varchar(80)	charset utf8	not null,
    color		varchar(20) charset utf8	not null,
	modification_date	timestamp	not null	default CURRENT_TIMESTAMP,
    constraint	PK_Tag_TagID	primary key(tag_id)
);

create table note(
	note_id		int		not null	auto_increment unique,
    course		int		not null,
    writer		varchar(120) charset utf8	null,
    uploader	int		not null,
    `file`		longblob	not null,
    modification_date	timestamp	not null	default CURRENT_TIMESTAMP,
    constraint	PK_Note_NoteID	primary key(note_id),
    constraint FK_Note_Course foreign key(course)	references course(course_id) on update cascade on delete cascade,
    constraint FK_Note_Uploader	foreign key(uploader)	references `user`(user_id) on update cascade on delete cascade
);

create table note_tag(
	note	int		not null,
    tag		int		not null,
    constraint FK_Note_Tag_NoteID	foreign key(note)	references note(note_id) on update cascade on delete cascade,
    constraint FK_Note_Tag_TagID	foreign key(tag)	references tag(tag_id)	on update cascade on delete cascade,
    constraint PK_Note_Tag_NoteID_TagID		primary key(note, tag)
);

create table question(
	question_id		int		not null	auto_increment	unique,
    question_text	text not null,
    answer			text not null,
    contributor		varchar(120) charset utf8 not null,
    question_type	enum('descriptive', 'test', 'other')		not null,
    modification_date	timestamp	not null	default CURRENT_TIMESTAMP,
    constraint	PK_Question_QuestionID	primary key(question_id)
);

create table online_exam(
	online_exam_id		int		not null	auto_increment	unique,
    course		int		not null,
    modification_date	timestamp	not null	default CURRENT_TIMESTAMP,
    constraint	PK_OnlineExam_OnlineExamID	primary key(online_exam_id),
    constraint FK_OnlineExam_Course foreign key(course)	references course(course_id) on update cascade on delete cascade
);

create table online_exam_tag(
	online_exam		int		not null,
    tag		int		not null,
    constraint FK_OnlineExam_Tag_OnlineExamID	foreign key(online_exam)	references online_exam(online_exam_id) on update cascade on delete cascade,
    constraint FK_OnlineExam_Tag_TagID	foreign key(tag)	references tag(tag_id)	on update cascade on delete cascade,
    constraint PK_OnlineExam_Tag_OnlineExamID_TagID		primary key(online_exam, tag)
);

create table online_exam_question(
	online_exam		int		not null,
    question	int		not null,
    constraint FK_OnlineExam_Question_OnlineExamID	foreign key(online_exam)	references online_exam(online_exam_id) on update cascade on delete cascade,
    constraint FK_OnlineExam_Question_QuestionID	foreign key(question)	references question(question_id)	on update cascade on delete cascade,
    constraint PK_OnlineExam_Question_OnlineExamID_QuestionID		primary key(online_exam, question)
);

create table exam(
	exam_id		int		not null	auto_increment	unique,
	course		int		not null,
    uploader	int		not null,
    exam_date	datetime	not null,
    `file`		longblob	not null,
    modification_date	timestamp	not null	default CURRENT_TIMESTAMP,
    constraint	PK_Exam_ExamID	primary key(exam_id),
    constraint FK_Exam_Course foreign key(course)	references course(course_id) on update cascade on delete cascade,
    constraint FK_Exam_Uploader	foreign key(uploader)	references `user`(user_id) on update cascade on delete cascade
);

create table exam_tag(
	exam	int		not null,
    tag		int		not null,
    constraint FK_Exam_Tag_ExamID	foreign key(exam)	references exam(exam_id) on update cascade on delete cascade,
    constraint FK_Exam_Tag_TagID	foreign key(tag)	references tag(tag_id)	on update cascade on delete cascade,
    constraint PK_Exam_Tag_ExamID_TagID		primary key(exam, tag)
);
/*
create table token(
    id      bigint  not null auto_increment    unique,
    token   varchar(50) charset utf8	not null,
    `user`  int     not null,
    expiry_time     timestamp    not null,
    constraint PK_Token_TokenId     primary key(id),
    constraint FK_Token_User	foreign key(user)	references `user`(user_id) on update cascade on delete cascade
);
 */