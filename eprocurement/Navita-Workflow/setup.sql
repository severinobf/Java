use apprest;

alter table user_portal add column private_key varchar(4096);
alter table user_portal add column public_key varchar(4096);

USE eprocurement;

drop table Tenant;

CREATE TABLE Tenant (
  	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	foreign_uuid varchar(255),
	name varchar (255),
	shortname varchar (255)
);

CREATE TABLE Carrier (
  	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	foreign_uuid varchar(255),
	name varchar(255),
	shortname varchar(255),
	integrationUrl varchar(255),
	integrationEmail varchar(255)
);

ALTER TABLE Carrier ADD UNIQUE INDEX(shortname);

CREATE TABLE Sku (
	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	foreign_uuid varchar(255),
	short_description text,
	long_description text,
	technical_characteristics text,
	warranty varchar(2048),
	url_thumbnail varchar(255),
	url_image varchar(255),
	productType varchar(255),
	model varchar(255),
	dual_chip varchar(255),
	manufacturer varchar(255),
	price double,
	platform varchar(255),
	lastModificationTyme timestamp
);


CREATE TABLE TenantConfiguration (
	tenant_id bigint(20) not null,
	carrier_id bigint(20) not null,
	sku_id bigint(20) not null,
	role_description varchar(255),
	group_description varchar(255),
	creationTime timestamp,
	isActive boolean,
	price double,
	fine double,
	daysForCommodatum int,
	basePriceForCommodatum double
);

alter table TenantConfiguration add constraint fk_configuration_sku foreign key fk_config_sku(sku_id) references sku(id);

CREATE TABLE Process (
	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	description varchar(255),
	short_description varchar(255),
	implementation_id varchar(255)
);

CREATE TABLE ProcessStep (
	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	description varchar(255),
	short_description varchar(255),
	implementation_id varchar(255)
);

CREATE TABLE ProcessSteps (
	process_id bigint(20),
	processStep_id bigint(20),
	foreign key fk_processsteps_process(process_id) references Process(id),
	foreign key fk_processsteps_step(processStep_id) references ProcessStep(id)
);

CREATE TABLE Attachment (
	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name varchar(255),
	path varchar(255),
	signable boolean
);

CREATE TABLE Content (
	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	attachment_id bigint(20),
	date_insertion timestamp,
	contentOwner bigint(20),
	signature varchar(255),
	document_path varchar(255),
	signed_document_path varchar(255),
	foreign key fk_content_attachment(attachment_id) references Attachment(id)
);

CREATE TABLE ProcessSetup (
	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	tenant_id bigint(20),
	process_id bigint(20),
	processStep_id bigint(20),
	setupTime timestamp,
	groupName varchar(255),
	personID varchar(255),
	role_description varchar(255),
	foreign key fk_processsetup_tenant(tenant_id) references Tenant(id),
	foreign key fk_processsetup_process(process_id) references Process(id),
	foreign key fk_processsetup_processstep(processStep_id) references ProcessStep(id)
);

CREATE TABLE ProcessStep_Attachment (
	processStep_id bigint(20),
	attachment_id bigint(20),
	tenant_id bigint(20),
	foreign key fk_psa_processstep(processStep_id) references ProcessStep(id),
	foreign key fk_psa_attachment(attachment_id) references Attachment(id),
	foreign key fk_psa_tenant(tenant_id) references Tenant(id)
);

CREATE TABLE ProcessTransaction (
	id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	processSetup_id bigint(20),
	processingTime timestamp,
	transactionOwner bigint(20),
	status boolean,
	foreign key fk_processtransaction_processsetup(processSetup_id) references ProcessSetup(id)
);

CREATE TABLE ProcessTransactionContent (
	processTransaction_id bigint(20),
	content_id bigint(20),
	foreign key fk_transactioncontent_transaction(processTransaction_id) references ProcessTransaction(id),
	foreign key fk_transactioncontent_content(content_id) references Content(id)
);

