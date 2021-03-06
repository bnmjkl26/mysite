-- insert (글쓰기)
insert
  into board
values ( board_no_seq.nextval, '첫글입니다.', '안녕하세요', 4, 0, SYSDATE );

commit;

select * from board;

-- select( 글목록 )
select a.no,
       a.title,
	   a.member_no,
	   b.name as member_name,
	   a.view_cnt,
	   to_char(a.reg_date, 'yyyy-mm-dd hh:MM:ss')
  from board a,
       member b
 where a.member_no = b.no
order by a.reg_date desc;
 
-- select( 글보기 )
select no, title, content, member_no
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
 	    
-- update( 조회수 늘리기 )
update board
   set view_cnt = view_cnt + 1
 where no = 1;	    

		