insert into coupons(code,discount_percentage)
values ('OFF5',5);
insert into coupons(code,discount_percentage)
values ('OFF10',10);

insert into users(username)
values ('ujjwal');

insert into orders(quantity,amount,coupon,date,status,user_id)
values (10,950.0,'OFF5','2024-03-22','SUCCESSFUL',1);
insert into orders(quantity,amount,coupon,date,status,user_id)
values (20,1900.0,'OFF5','2024-03-25','SUCCESSFUL',1);
insert into orders(quantity,amount,coupon,date,status,user_id)
values (10,900.0,'OFF10','2024-03-28','SUCCESSFUL',1);
insert into orders(quantity,amount,coupon,date,status,user_id)
values (50,4500.0,'OFF10','2024-04-01','SUCCESSFUL',1);
insert into orders(quantity,amount,coupon,date,status,user_id)
values (100,9000.0,'OFF10','2024-04-01','SUCCESSFUL',1);
