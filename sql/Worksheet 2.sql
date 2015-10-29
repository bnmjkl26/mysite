				insert
				into guestbook 
				values( guestbook_seq.nextval, '테스트', '1234', '테스트입니다.', SYSDATE );

select guestbook_seq.currval from dual;