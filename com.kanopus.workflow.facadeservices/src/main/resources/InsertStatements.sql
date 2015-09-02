INSERT INTO `workflowfacade`.`role_master`
(`ROLE_CDE`,
`ROLE_DESC`)
VALUES
("ADMIN","Administrator");

INSERT INTO `workflowfacade`.`role_master`
(`ROLE_CDE`,
`ROLE_DESC`)
VALUES
("USER","User Rights");

INSERT INTO `workflowfacade`.`role_previlige`
(`ROLE_CDE`,
`CAN_START_CASE`,
`CAN_SEND_MESSAGE`,
`CAN_CLAIM_TASK`,
`CAN_VIEWONLY_TASK`,
`CAN_SEARCH_TASK`,
`CAN_PURGE_CASE`,
`CAN_SUSPEND_CASE`,
`CAN_PARTICIPATE_CASE`,
`CAN_SEE_REPORTS`)
VALUES
("ADMIN",1,1,1,1,1,1,1,1,1);

INSERT INTO `workflowfacade`.`role_previlige`
(`ROLE_CDE`,
`CAN_START_CASE`,
`CAN_SEND_MESSAGE`,
`CAN_CLAIM_TASK`,
`CAN_VIEWONLY_TASK`,
`CAN_SEARCH_TASK`,
`CAN_PURGE_CASE`,
`CAN_SUSPEND_CASE`,
`CAN_PARTICIPATE_CASE`,
`CAN_SEE_REPORTS`)
VALUES
("USER",1,1,1,1,1,0,0,1,0);

INSERT INTO `workflowfacade`.`user_role`
(`ID`,
`ROLE_CDE`)
VALUES
("1","ADMIN");

INSERT INTO `workflowfacade`.`user_role`
(`ID`,
`ROLE_CDE`)
VALUES
("2","USER");

INSERT INTO `workflowfacade`.`user_auth`
(`ID`,
`EMAIL_ADDRESS`,
`PASSWORD`,
`WORKFLOW_REF_USERID`,
`IS_ACTIVE`,
`IS_AUTHORIZATION_ONLY`)
VALUES
("1","bala.arun@gmail.com","abcd1234","1",1,0);

INSERT INTO `workflowfacade`.`user_auth`
(`ID`,
`EMAIL_ADDRESS`,
`PASSWORD`,
`WORKFLOW_REF_USERID`,
`IS_ACTIVE`,
`IS_AUTHORIZATION_ONLY`)
VALUES
("2","arunkumar.nh@gmail.com","abcd@4567","1",1,1);

INSERT INTO `workflowfacade`.`managed_workflows`
(`WORKFLOW_PROCESS_ID`,
`WORKFLOW_NAME`,
`BUSINESSKEY_PREFIX`)
VALUES
("WF_001",
"Batch Process",
"BAT");

INSERT INTO `workflowfacade`.`managed_workflows`
(`WORKFLOW_PROCESS_ID`,
`WORKFLOW_NAME`,
`BUSINESSKEY_PREFIX`)
VALUES
("WF_002",
"Profile Process",
"PRF");

INSERT INTO `workflowfacade`.`workflow_role_config`
(`ROLE_CDE`,
`WORKFLOW_PROCESS_ID`,
`CANSTARTINSTANCE`,
`CANSENDMESSAGE`)
VALUES
("USER",
"WF_001",
1,
0);

INSERT INTO `workflowfacade`.`workflow_role_config`
(`ROLE_CDE`,
`WORKFLOW_PROCESS_ID`,
`CANSTARTINSTANCE`,
`CANSENDMESSAGE`)
VALUES
("ADMIN",
"WF_002",
1,
1);

INSERT INTO `workflowfacade`.`workflow_role_config`
(`ROLE_CDE`,
`WORKFLOW_PROCESS_ID`,
`CANSTARTINSTANCE`,
`CANSENDMESSAGE`)
VALUES
("ADMIN",
"WF_001",
1,
1);
