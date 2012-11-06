create table los_area (id numeric(18,0) not null, areaType varchar(255), primary key (id));
create table los_avisreq (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, adviceNumber varchar(255) not null unique, externalNo varchar(255), receiptAmount numeric(17,4), expectedDelivery date, expireBatch smallint not null, notifiedAmount numeric(17,4), adviceState varchar(255), externalId varchar(255), client_id numeric(18,0) not null, lot_id numeric(18,0), itemData_id numeric(18,0) not null, primary key (id));
create table los_bom (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, amount numeric(17,4) not null, pickable smallint not null, "BOM_INDEX" integer, parent_id numeric(18,0) not null, child_id numeric(18,0) not null, primary key (id), unique (parent_id, child_id));
create table los_extinguishreq (id numeric(18,0) not null, lot_id numeric(18,0), primary key (id));
create table los_extorder (id numeric(18,0) not null, lot_id numeric(18,0), authorizedBy_id numeric(18,0), primary key (id));
create table los_fixassgn (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, desiredAmount numeric(17,4) not null, itemData_id numeric(18,0) not null, assignedLocation_id numeric(18,0) not null, primary key (id), unique (assignedLocation_id));
create table los_goodsreceipt (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, driverName varchar(255), receiptDate date, gr_number varchar(255) not null unique, licencePlate varchar(255), forwarder varchar(255), delnote varchar(255), receiptState varchar(255), referenceNo varchar(255), operator_id numeric(18,0) not null, goodsInLocation_id numeric(18,0), client_id numeric(18,0) not null, primary key (id));
create table los_goodsreceipt_los_avisreq (los_goodsreceipt_id numeric(18,0) not null, assignedAdvices_id numeric(18,0) not null);
create table los_grrposition (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, scale integer not null, itemData varchar(255), amount numeric(17,4), unitLoad varchar(255), lot varchar(255), positionNumber varchar(255) unique, orderReference varchar(255), stockUnitStr varchar(255), receiptType varchar(255), qaFault varchar(1024), state integer, relatedAdvice_id numeric(18,0), stockUnit_id numeric(18,0), goodsReceipt_id numeric(18,0) not null, client_id numeric(18,0) not null, primary key (id));
create table los_inventory (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, itemDataRef varchar(255), reserved numeric(19,2), available numeric(19,2), locked numeric(19,2), advised numeric(19,2), inStock numeric(19,2), lastIncoming timestamp, lastAmount numeric(19,2), lotRef varchar(255), client_id numeric(18,0) not null, primary key (id), unique (lotRef, client_id));
create table los_itemdata_number (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, manufacturerName varchar(255), "EANUMBER" varchar(255) not null, "IDN_INDEX" integer, itemData_id numeric(18,0) not null, client_id numeric(18,0) not null, primary key (id), unique ("EANUMBER", itemData_id));
create table los_jrxml (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, jrXML blob, name varchar(255), client_id numeric(18,0) not null, primary key (id), unique (name, client_id));
create table los_locationcluster (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, name varchar(255) not null unique, primary key (id));
create table los_order (id numeric(18,0) not null, primary key (id));
create table los_orderreceipt (id numeric(18,0) not null, "OR_USER_" varchar(255) not null, orderType varchar(255) not null, orderReference varchar(255), orderNumber varchar(255) not null, state varchar(255), "OR_DATE" timestamp not null, destination varchar(255), primary key (id));
create table los_orderreceiptpos (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, amount numeric(17,4), lotRef varchar(255), articleRef varchar(255), articleDescr varchar(255), amountordered numeric(17,4), articleScale integer not null, pos integer not null, receipt_id numeric(18,0), client_id numeric(18,0) not null, primary key (id));
create table los_orderreq (id numeric(18,0) not null, orderState varchar(255), delivery date, requestId varchar(255), documentUrl varchar(255), labelUrl varchar(255), orderType varchar(255), destination_id numeric(18,0) not null, primary key (id));
create table los_orderreqpos (id numeric(18,0) not null, amount numeric(17,4), positionIndex integer not null, partitionAllowed smallint not null, positionState varchar(255), pickedAmount numeric(17,4), itemData_id numeric(18,0) not null, lot_id numeric(18,0), parentRequest_id numeric(18,0) not null, primary key (id));
create table los_outpos (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, outState varchar(255), goodsOutRequest_id numeric(18,0) not null, source_id numeric(18,0) not null, primary key (id), unique (source_id));
create table los_outreq (id numeric(18,0) not null, outState varchar(255), parentRequest_id numeric(18,0) not null, operator_id numeric(18,0), primary key (id));
create table los_pickreceipt (id numeric(18,0) not null, orderNumber varchar(255), labelID varchar(255), pickNumber varchar(255), state varchar(255), "PR_DATE" timestamp, primary key (id));
create table los_pickreceiptpos (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, amount numeric(17,4), lotRef varchar(255), articleRef varchar(255), articleDescr varchar(255), amountordered numeric(17,4), receipt_id numeric(18,0), primary key (id));
create table los_pickreq (id numeric(18,0) not null, customerNumber varchar(255), state varchar(255), cart_id numeric(18,0), user_id numeric(18,0), parentRequest_id numeric(18,0) not null, destination_id numeric(18,0) not null, primary key (id));
create table los_pickreqpos (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, amount numeric(17,4) not null, pickedAmount numeric(17,4) not null, solved smallint not null, canceled smallint not null, pickingSupplyType varchar(255), pickingDimensionType varchar(255), withdrawalType varchar(255), substitutionType varchar(255), pos_index integer, parentRequest_id numeric(18,0) not null, pickRequest_id numeric(18,0) not null, complementOn_id numeric(18,0), stockUnit_id numeric(18,0) not null, primary key (id));
create table los_rack (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, numberOfRows integer not null, numberOfColumns integer not null, labelOffset integer, rname varchar(255) not null, client_id numeric(18,0) not null, primary key (id), unique (client_id, rname));
create table los_racklocation (id numeric(18,0) not null, XPos integer not null, YPos integer not null, ZPos integer not null, rack_id numeric(18,0) not null, primary key (id));
create table los_replenishreq (id numeric(18,0) not null, primary key (id));
create table los_replenishreq_los_storloc (los_replenishreq_id numeric(18,0) not null, allowedSources_id numeric(18,0) not null);
create table los_sequenceNumber (className varchar(255) not null, sequenceNumber numeric(18,0) not null, version integer not null, primary key (className));
create table los_serviceconf (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, subkey varchar(255), servValue varchar(255), servKey varchar(255) not null, service varchar(255) not null, client_id numeric(18,0) not null, primary key (id), unique (service, client_id, servKey));
create table los_slLabel (id numeric(18,0) not null, labelId varchar(255), primary key (id));
create table los_stockrecord (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, scale integer not null, itemData varchar(255), amount numeric(17,4), lot varchar(255), serialNumber varchar(255), operator varchar(255) not null, toStockUnitIdentity varchar(255), fromStockUnitIdentity varchar(255), activityCode varchar(255) not null, amountStock numeric(17,4), toUnitLoad varchar(255), toStorageLocation varchar(255) not null, fromUnitLoad varchar(255), fromStorageLocation varchar(255) not null, type varchar(255), client_id numeric(18,0) not null, primary key (id));
create table los_stocktaking (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, stockTakingNumber varchar(255) not null unique, stockTakingType varchar(255), started timestamp, ended timestamp, primary key (id));
create table los_stocktakingorder (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, operator varchar(255), locationName varchar(255), unitLoadLabel varchar(255), areaName varchar(255), countingDate timestamp, state integer, stockTaking_id numeric(18,0), primary key (id));
create table los_stocktakingrecord (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, clientNo varchar(255), locationName varchar(255), unitLoadLabel varchar(255), itemNo varchar(255), lotNo varchar(255), plannedQuantity numeric(19,2), countedQuantity numeric(19,2), serialNo varchar(255), countedStockId numeric(18,0), ulTypeNo varchar(255), state integer, stocktakingOrder_id numeric(18,0), primary key (id));
create table los_storagelocationtype (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, volume numeric(19,6), liftingCapacity numeric(16,3), sltname varchar(255) not null, height numeric(15,2), width numeric(15,2), depth numeric(15,2), primary key (id), unique (sltname));
create table los_storagereq (id numeric(18,0) not null, requestState varchar(255), destination_id numeric(18,0), unitLoad_id numeric(18,0), primary key (id));
create table los_storloc (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, reservedCapacity integer not null, stockTakingDate timestamp, name varchar(255) not null unique, cluster_id numeric(18,0), area_id numeric(18,0), zone_id numeric(18,0), type_id numeric(18,0) not null, client_id numeric(18,0) not null, currentTCC numeric(18,0), primary key (id));
create table los_suLabel (id numeric(18,0) not null, scale integer not null, amount numeric(19,2) not null, itemUnit varchar(255) not null, lotRef varchar(255), labelID varchar(255) not null, clientRef varchar(255) not null, dateRef varchar(255) not null, itemdataRef varchar(255) not null, primary key (id));
create table los_sysprop (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, workstation varchar(255) not null, groupName varchar(255), sysvalue varchar(255) not null, syskey varchar(255) not null, hidden smallint not null, description varchar(255), client_id numeric(18,0) not null, primary key (id), unique (client_id, syskey, workstation));
create table los_typecapacityconstraint (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, capacity integer not null, name varchar(255) not null unique, storageLocationType_id numeric(18,0) not null, unitLoadType_id numeric(18,0), primary key (id), unique (storageLocationType_id, unitLoadType_id));
create table los_ul_record (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, operator varchar(255), activityCode varchar(255), fromLocation varchar(255) not null, toLocation varchar(255) not null, recordType varchar(255) not null, label varchar(255) not null, client_id numeric(18,0) not null, primary key (id));
create table los_uladvice (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, labelId varchar(255) not null unique, adviceState varchar(255) not null, externalNumber varchar(255), adviceType varchar(255) not null, reasonForReturn varchar(255), switchStateInfo varchar(255), "ULA_NUMBER" varchar(255) not null unique, unitLoadType_id numeric(18,0), relatedAdvice_id numeric(18,0), client_id numeric(18,0) not null, primary key (id));
create table los_uladvicepos (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, notifiedAmount numeric(17,4) not null, positionNumber varchar(255) not null, lot_id numeric(18,0), client_id numeric(18,0) not null, itemData_id numeric(18,0) not null, unitLoadAdvice_id numeric(18,0) not null, primary key (id));
create table los_unitload (id numeric(18,0) not null, stockTakingDate timestamp, packageType varchar(255), weightGross numeric(16,3), weightNet numeric(16,3), storageLocation_id numeric(18,0) not null, primary key (id));
create table los_work_type (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, remarks varchar(255), worktype varchar(255) not null, periodic smallint not null, periodicCircle numeric(15,2), completionTime numeric(15,2), primary key (id), unique (worktype));
create table mywms_area (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, name varchar(255) not null, client_id numeric(18,0) not null, primary key (id), unique (client_id, name));
create table mywms_clearingitem (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, user_ varchar(255) not null, messageResourceKey varchar(255) not null, messageParameters blob not null, options blob not null, solver varchar(255), solution blob, shortMessageResourceKey varchar(255) not null, shortMessageParameters blob not null, propertyMap blob, bundleResolver blob, host varchar(255) not null, source varchar(255) not null, resourceBundleName varchar(255) not null, client_id numeric(18,0) not null, primary key (id));
create table mywms_client (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, email varchar(255), phone varchar(255), fax varchar(255), name varchar(255) not null unique, cl_nr varchar(255) not null unique, cl_code varchar(255) unique, primary key (id));
create table mywms_document (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, name varchar(255) not null, type varchar(255) not null, document_size integer, document blob not null, client_id numeric(18,0) not null, primary key (id), unique (client_id, name));
create table mywms_itemdata (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, safetyStock integer not null, rest_Usage_GI integer, lotMandatory smallint not null, lotSubstitutionType varchar(255), adviceMandatory smallint not null, serialRecType varchar(255) not null, scale integer not null, volume numeric(19,6), tradeGroup varchar(255), stnr varchar(255), remarks varchar(255), price numeric(15,2), errc char not null, appl varchar(255), expectedreplenishment timestamp, receiptDate timestamp, storageDate timestamp, name varchar(255) not null, item_nr varchar(255) not null, height numeric(15,2), width numeric(15,2), weight numeric(16,3), descr varchar(255), depth numeric(15,2), defULType_id numeric(18,0), client_id numeric(18,0) not null, handlingUnit_id numeric(18,0) not null, zone_id numeric(18,0), primary key (id), unique (client_id, item_nr));
create table mywms_itemunit (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, unitType varchar(255), unitName varchar(255) not null, baseFactor integer not null, baseUnit_id numeric(18,0), primary key (id));
create table mywms_logitem (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, user_ varchar(255) not null, messageResourceKey varchar(255) not null, messageParameters blob, bundleResolver varchar(255), message varchar(255) not null, type varchar(255) not null, host varchar(255) not null, source varchar(255) not null, resourceBundleName varchar(255) not null, client_id numeric(18,0) not null, primary key (id));
create table mywms_lot (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, volume numeric(19,6), useNotBefore date, bestBeforeEnd date, age varchar(255), name varchar(255), lot_date date not null, height numeric(15,2), width numeric(15,2), weight numeric(16,3), depth numeric(15,2), code varchar(255), client_id numeric(18,0) not null, itemData_id numeric(18,0) not null, primary key (id), unique (name, itemData_id));
create table mywms_pluginconfiguration (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, plugin_mode varchar(255) not null, pluginClass varchar(255) not null, pluginName varchar(255) not null, client_id numeric(18,0) not null, primary key (id), unique (client_id, pluginName, plugin_mode));
create table mywms_request (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, parentRequestNumber varchar(255), request_nr varchar(255) not null unique, client_id numeric(18,0) not null, primary key (id));
create table mywms_role (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, name varchar(255) not null unique, description varchar(255) not null, primary key (id));
create table mywms_stockunit (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, amount numeric(17,4) not null, labelId varchar(255) not null, reservedAmount numeric(17,4), serialNumber varchar(255), client_id numeric(18,0) not null, itemData_id numeric(18,0) not null, lot_id numeric(18,0), unitLoad_id numeric(18,0) not null, primary key (id), unique (labelId, itemData_id));
create table mywms_unitload (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, labelId varchar(255) not null unique, location_index integer, client_id numeric(18,0) not null, type_id numeric(18,0) not null, primary key (id));
create table mywms_unitloadtype (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, volume numeric(19,6), liftingCapacity numeric(16,3), name varchar(255) not null, height numeric(15,2), width numeric(15,2), weight numeric(16,3), depth numeric(15,2), primary key (id), unique (name));
create table mywms_user (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, email varchar(255), phone varchar(255), firstname varchar(255), lastname varchar(255), name varchar(255) not null unique, locale varchar(255), password varchar(255) not null, client_id numeric(18,0) not null, primary key (id));
create table mywms_user_mywms_role (mywms_user_id numeric(18,0) not null, roles_id numeric(18,0) not null);
create table mywms_vehicledata (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, remarks varchar(255), receiptDate timestamp, storageDate timestamp, manufacturerName varchar(255), labelId varchar(255) not null, modelName varchar(255), plateNumber varchar(255), chassisNumber varchar(255), engineNumber varchar(255), mileage numeric(15,2), primary key (id), unique (labelId));
create table mywms_workitem (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, remarks varchar(255), urgent smallint not null, scheduleTime timestamp, executeDeadline timestamp, itemDataId_id numeric(18,0) not null, workTypeId_id numeric(18,0) not null, workerId_id numeric(18,0) not null, primary key (id));
create table mywms_workitemhistory (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, remarks varchar(255), urgent smallint not null, scheduleTime timestamp, executeDeadline timestamp, completionSuccess smallint not null, completionDate timestamp, completionRemarks varchar(255), itemDataId_id numeric(18,0) not null, workTypeId_id numeric(18,0) not null, workerId_id numeric(18,0) not null, primary key (id));
create table mywms_workvehicle (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, remarks varchar(255), labelId varchar(255) not null, urgent smallint not null, scheduleTime timestamp, executeDeadline timestamp, workerId_id numeric(18,0) not null, workTypeId_id numeric(18,0) not null, vehicleDataId_id numeric(18,0) not null, primary key (id), unique (labelId));
create table mywms_workvehiclehistory (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, completionSuccess smallint not null, completionDate timestamp, completionRemarks varchar(255), primary key (id));
create table mywms_zone (id numeric(18,0) not null, created timestamp, modified timestamp, additionalContent varchar(255), version integer not null, entity_lock integer, name varchar(255) not null, client_id numeric(18,0) not null, primary key (id), unique (client_id, name));
alter table los_area add constraint FK8C78781C5A8B1214 foreign key (id) references mywms_area;
alter table los_avisreq add constraint FKBE36EA30DFB71F26 foreign key (itemData_id) references mywms_itemdata;
alter table los_avisreq add constraint FKBE36EA30EAD3F22E foreign key (lot_id) references mywms_lot;
alter table los_avisreq add constraint FKBE36EA307576A346 foreign key (client_id) references mywms_client;
alter table los_bom add constraint FK150C28516FA752E7 foreign key (child_id) references mywms_itemdata;
alter table los_bom add constraint FK150C28518823EC99 foreign key (parent_id) references mywms_itemdata;
alter table los_extinguishreq add constraint FKCB6B2025264B99AA foreign key (id) references los_pickreq;
alter table los_extinguishreq add constraint FKCB6B2025EAD3F22E foreign key (lot_id) references mywms_lot;
alter table los_extorder add constraint FK248471DCF4DCC426 foreign key (id) references los_orderreq;
alter table los_extorder add constraint FK248471DCEAD3F22E foreign key (lot_id) references mywms_lot;
alter table los_extorder add constraint FK248471DCCF4E57F foreign key (authorizedBy_id) references mywms_user;
alter table los_fixassgn add constraint FK78F6EC4297747C46 foreign key (assignedLocation_id) references los_storloc;
alter table los_fixassgn add constraint FK78F6EC42DFB71F26 foreign key (itemData_id) references mywms_itemdata;
alter table los_goodsreceipt add constraint FK81CDB6B162A4F6CD foreign key (operator_id) references mywms_user;
alter table los_goodsreceipt add constraint FK81CDB6B17576A346 foreign key (client_id) references mywms_client;
alter table los_goodsreceipt add constraint FK81CDB6B1DC91D4F9 foreign key (goodsInLocation_id) references los_storloc;
alter table los_goodsreceipt_los_avisreq add constraint FKDEA77DA2EB5589CF foreign key (assignedAdvices_id) references los_avisreq;
alter table los_goodsreceipt_los_avisreq add constraint FKDEA77DA2ACB9FF15 foreign key (los_goodsreceipt_id) references los_goodsreceipt;
alter table los_grrposition add constraint FKBB47DCA1CBC10219 foreign key (relatedAdvice_id) references los_avisreq;
alter table los_grrposition add constraint FKBB47DCA1BC27A604 foreign key (goodsReceipt_id) references los_goodsreceipt;
alter table los_grrposition add constraint FKBB47DCA1E06B76AE foreign key (stockUnit_id) references mywms_stockunit;
alter table los_grrposition add constraint FKBB47DCA17576A346 foreign key (client_id) references mywms_client;
alter table los_inventory add constraint FK6DAD32D7576A346 foreign key (client_id) references mywms_client;
alter table los_itemdata_number add constraint FK2CAC199CDFB71F26 foreign key (itemData_id) references mywms_itemdata;
alter table los_itemdata_number add constraint FK2CAC199C7576A346 foreign key (client_id) references mywms_client;
alter table los_jrxml add constraint FK315A8207576A346 foreign key (client_id) references mywms_client;
alter table los_order add constraint FK35BD19FF4DCC426 foreign key (id) references los_orderreq;
alter table los_orderreceipt add constraint FK2B445FB9F9F1FCA2 foreign key (id) references mywms_document;
alter table los_orderreceiptpos add constraint FK9C10BFB6B21192 foreign key (receipt_id) references los_orderreceipt;
alter table los_orderreceiptpos add constraint FK9C10BFB7576A346 foreign key (client_id) references mywms_client;
alter table los_orderreq add constraint FKDA108E9F5A663BE foreign key (id) references mywms_request;
alter table los_orderreq add constraint FKDA108E9F610EE7DB foreign key (destination_id) references los_storloc;
alter table los_orderreqpos add constraint FK6CC6AB555A663BE foreign key (id) references mywms_request;
alter table los_orderreqpos add constraint FK6CC6AB55DFB71F26 foreign key (itemData_id) references mywms_itemdata;
alter table los_orderreqpos add constraint FK6CC6AB55EAD3F22E foreign key (lot_id) references mywms_lot;
alter table los_orderreqpos add constraint FK6CC6AB552772B400 foreign key (parentRequest_id) references los_orderreq;
alter table los_outpos add constraint FK68501815685FC38A foreign key (source_id) references los_unitload;
alter table los_outpos add constraint FK6850181574799270 foreign key (goodsOutRequest_id) references los_outreq;
alter table los_outreq add constraint FK68501E5F5A663BE foreign key (id) references mywms_request;
alter table los_outreq add constraint FK68501E5F62A4F6CD foreign key (operator_id) references mywms_user;
alter table los_outreq add constraint FK68501E5F2772B400 foreign key (parentRequest_id) references los_orderreq;
alter table los_pickreceipt add constraint FK2FC84488F9F1FCA2 foreign key (id) references mywms_document;
alter table los_pickreceiptpos add constraint FK7A60C0CCD69B7E28 foreign key (receipt_id) references los_pickreceipt;
alter table los_pickreq add constraint FKC12D32EE4BAF7F89 foreign key (cart_id) references los_storloc;
alter table los_pickreq add constraint FKC12D32EE5A663BE foreign key (id) references mywms_request;
alter table los_pickreq add constraint FKC12D32EE51CF0E46 foreign key (user_id) references mywms_user;
alter table los_pickreq add constraint FKC12D32EE610EE7DB foreign key (destination_id) references los_storloc;
alter table los_pickreq add constraint FKC12D32EE2772B400 foreign key (parentRequest_id) references los_orderreq;
alter table los_pickreqpos add constraint FK2ADB70A6291583B foreign key (pickRequest_id) references los_pickreq;
alter table los_pickreqpos add constraint FK2ADB70A6E06B76AE foreign key (stockUnit_id) references mywms_stockunit;
alter table los_pickreqpos add constraint FK2ADB70A66297649 foreign key (parentRequest_id) references los_orderreqpos;
alter table los_pickreqpos add constraint FK2ADB70A68ACB6FED foreign key (complementOn_id) references los_pickreqpos;
alter table los_rack add constraint FK8C7FF2667576A346 foreign key (client_id) references mywms_client;
alter table los_racklocation add constraint FKD301CC1B2AA3EA0A foreign key (id) references los_storloc;
alter table los_racklocation add constraint FKD301CC1B6E957A1B foreign key (rack_id) references los_rack;
alter table los_replenishreq add constraint FK21BAB647F4DCC426 foreign key (id) references los_orderreq;
alter table los_replenishreq_los_storloc add constraint FKF5EE48D58B688799 foreign key (allowedSources_id) references los_storloc;
alter table los_replenishreq_los_storloc add constraint FKF5EE48D51D030746 foreign key (los_replenishreq_id) references los_replenishreq;
alter table los_serviceconf add constraint FK64999CEA7576A346 foreign key (client_id) references mywms_client;
alter table los_slLabel add constraint FK63B58A2CF9F1FCA2 foreign key (id) references mywms_document;
alter table los_stockrecord add constraint FKC5C8C4787576A346 foreign key (client_id) references mywms_client;
alter table los_stocktakingorder add constraint FK9D2E768377483CF2 foreign key (stockTaking_id) references los_stocktaking;
alter table los_stocktakingrecord add constraint FKD0763BCD68666C2 foreign key (stocktakingOrder_id) references los_stocktakingorder;
alter table los_storagereq add constraint FK9A96A0925A663BE foreign key (id) references mywms_request;
alter table los_storagereq add constraint FK9A96A092C7DA58DB foreign key (unitLoad_id) references los_unitload;
alter table los_storagereq add constraint FK9A96A092610EE7DB foreign key (destination_id) references los_storloc;
alter table los_storloc add constraint FK735166CD85E165B foreign key (area_id) references los_area;
alter table los_storloc add constraint FK735166CD8BCAF84D foreign key (currentTCC) references los_typecapacityconstraint;
alter table los_storloc add constraint FK735166CD2EB48BA4 foreign key (cluster_id) references los_locationcluster;
alter table los_storloc add constraint FK735166CD53F5F6A6 foreign key (zone_id) references mywms_zone;
alter table los_storloc add constraint FK735166CD7576A346 foreign key (client_id) references mywms_client;
alter table los_storloc add constraint FK735166CD17CCB109 foreign key (type_id) references los_storagelocationtype;
alter table los_suLabel add constraint FK731127C3F9F1FCA2 foreign key (id) references mywms_document;
alter table los_sysprop add constraint FK7C112DC17576A346 foreign key (client_id) references mywms_client;
alter table los_typecapacityconstraint add constraint FK882380A02C6A1FE6 foreign key (unitLoadType_id) references mywms_unitloadtype;
alter table los_typecapacityconstraint add constraint FK882380A0C34A03D9 foreign key (storageLocationType_id) references los_storagelocationtype;
alter table los_ul_record add constraint FK7F46CCCA7576A346 foreign key (client_id) references mywms_client;
alter table los_uladvice add constraint FK6C7465ECBC10219 foreign key (relatedAdvice_id) references los_avisreq;
alter table los_uladvice add constraint FK6C7465E2C6A1FE6 foreign key (unitLoadType_id) references mywms_unitloadtype;
alter table los_uladvice add constraint FK6C7465E7576A346 foreign key (client_id) references mywms_client;
alter table los_uladvicepos add constraint FKCFD76736DFB71F26 foreign key (itemData_id) references mywms_itemdata;
alter table los_uladvicepos add constraint FKCFD7673629B0FBE4 foreign key (unitLoadAdvice_id) references los_uladvice;
alter table los_uladvicepos add constraint FKCFD76736EAD3F22E foreign key (lot_id) references mywms_lot;
alter table los_uladvicepos add constraint FKCFD767367576A346 foreign key (client_id) references mywms_client;
alter table los_unitload add constraint FK7F1784798CDC8979 foreign key (storageLocation_id) references los_storloc;
alter table los_unitload add constraint FK7F178479B51FDC11 foreign key (id) references mywms_unitload;
alter table mywms_area add constraint FKB0F690DB7576A346 foreign key (client_id) references mywms_client;
alter table mywms_clearingitem add constraint FKF83EED567576A346 foreign key (client_id) references mywms_client;
alter table mywms_document add constraint FKD610BA697576A346 foreign key (client_id) references mywms_client;
alter table mywms_itemdata add constraint FKE8EA928B132AA2D4 foreign key (handlingUnit_id) references mywms_itemunit;
alter table mywms_itemdata add constraint FKE8EA928BEA8A22B4 foreign key (defULType_id) references mywms_unitloadtype;
alter table mywms_itemdata add constraint FKE8EA928B53F5F6A6 foreign key (zone_id) references mywms_zone;
alter table mywms_itemdata add constraint FKE8EA928B7576A346 foreign key (client_id) references mywms_client;
alter table mywms_itemunit add constraint FKE8F27C6521A5FB68 foreign key (baseUnit_id) references mywms_itemunit;
alter table mywms_logitem add constraint FKA60A91497576A346 foreign key (client_id) references mywms_client;
alter table mywms_lot add constraint FK9218A143DFB71F26 foreign key (itemData_id) references mywms_itemdata;
alter table mywms_lot add constraint FK9218A1437576A346 foreign key (client_id) references mywms_client;
alter table mywms_pluginconfiguration add constraint FKA9F86A957576A346 foreign key (client_id) references mywms_client;
alter table mywms_request add constraint FKD2F1A7817576A346 foreign key (client_id) references mywms_client;
alter table mywms_stockunit add constraint FKFF6D960CDFB71F26 foreign key (itemData_id) references mywms_itemdata;
alter table mywms_stockunit add constraint FKFF6D960CEAD3F22E foreign key (lot_id) references mywms_lot;
alter table mywms_stockunit add constraint FKFF6D960CC7DA58DB foreign key (unitLoad_id) references los_unitload;
alter table mywms_stockunit add constraint FKFF6D960CAF5EB406 foreign key (unitLoad_id) references mywms_unitload;
alter table mywms_stockunit add constraint FKFF6D960C7576A346 foreign key (client_id) references mywms_client;
alter table mywms_unitload add constraint FK914D25B87576A346 foreign key (client_id) references mywms_client;
alter table mywms_unitload add constraint FK914D25B83F624790 foreign key (type_id) references mywms_unitloadtype;
alter table mywms_user add constraint FKB0FFAC197576A346 foreign key (client_id) references mywms_client;
alter table mywms_user_mywms_role add constraint FK16F290AA4ABCC2BF foreign key (roles_id) references mywms_role;
alter table mywms_user_mywms_role add constraint FK16F290AAE371C338 foreign key (mywms_user_id) references mywms_user;
alter table mywms_workitem add constraint FKA4D13AF29565B6B foreign key (itemDataId_id) references mywms_itemdata;
alter table mywms_workitem add constraint FKA4D13AF2859C042B foreign key (workTypeId_id) references los_work_type;
alter table mywms_workitem add constraint FKA4D13AF295A6D638 foreign key (workerId_id) references mywms_user;
alter table mywms_workitemhistory add constraint FKEC55D5629565B6B foreign key (itemDataId_id) references mywms_itemdata;
alter table mywms_workitemhistory add constraint FKEC55D562859C042B foreign key (workTypeId_id) references los_work_type;
alter table mywms_workitemhistory add constraint FKEC55D56295A6D638 foreign key (workerId_id) references mywms_user;
alter table mywms_workvehicle add constraint FK8E9CCEED859C042B foreign key (workTypeId_id) references los_work_type;
alter table mywms_workvehicle add constraint FK8E9CCEED95A6D638 foreign key (workerId_id) references mywms_user;
alter table mywms_workvehicle add constraint FK8E9CCEED68594EB3 foreign key (vehicleDataId_id) references mywms_vehicledata;
alter table mywms_zone add constraint FKB101E3FA7576A346 foreign key (client_id) references mywms_client;
create generator seqEntities;
