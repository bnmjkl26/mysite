-- insert (글쓰기)
insert
  into board
values ( board_no_seq.nextval, '첫글입니다.', '안녕하세요', 4, 0, SYSDATE );

commit;

select * from board;

-- select( 글목록 )
select a.no,
       a.title,
	   a.content,
	   a.member_no,
	   b.NAME as member_name,
	   a.view_cnt,
	   to_char(a.reg_date, 'yyyy-mm-dd hh:MM:ss')
  from board a,
       member b
 where a.member_no = b.no;
 
-- select( 글보기 )
select *
  from board
 where no = 1;

-- update( 글수정 )
update board
   set title='수정된 글입니다.',
       content='하이'
 where no = 1;	    

-- delete ( 글삭제 )
delete
  from board
 where no = 1;  
 	    
		