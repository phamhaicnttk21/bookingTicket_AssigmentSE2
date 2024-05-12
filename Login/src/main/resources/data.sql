INSERT INTO `movies` (`id`,`movie_name`, `genre`, `poster_url`, `base_cost`)
VALUES
(1,"No man's land", "Action", "https://i.ytimg.com/vi/7AJXcuf1uKI/maxresdefault.jpg", "200000"),
(2,"8-year-old bride", "Drama, Slice-of-life", "https://i.ytimg.com/vi/58fqhHTc5A8/maxresdefault.jpg", "100000"),
(3,"Finding Nemo", "Adventure", "https://lumiere-a.akamaihd.net/v1/images/p_findingnemo_19752_05271d3f.jpeg", "125000"),
(4,"The Thing", "Action, Horror", "https://m.media-amazon.com/images/M/MV5BNGViZWZmM2EtNGYzZi00ZDAyLTk3ODMtNzIyZTBjN2Y1NmM1XkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_.jpg", "225000"),
(5,"The Thing 2: Prequel", "Action, Horror", "https://m.media-amazon.com/images/M/MV5BMTMxMjI0MzUyNl5BMl5BanBnXkFtZTcwNjc1NzE5NQ@@._V1_QL75_UX190_CR0,0,190,281_.jpg", "220000"),
(6,"John Wick 3: Parabellum", "Action, Drama", "https://m.media-amazon.com/images/M/MV5BMDg2YzI0ODctYjliMy00NTU0LTkxODYtYTNkNjQwMzVmOTcxXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_.jpg", "240000")
ON DUPLICATE KEY UPDATE
    movie_name = VALUES(movie_name);


INSERT INTO `theater` (`id`,`theater_name`, `a_section`, `b_section`, `vip_section`, `address`, `image_url`)
VALUES
(1,"National Cinema Center", "30", "20", "10", "87 P. Láng Hạ, Chợ Dừa, Ba Đình, Hà Nội", "https://api.chieuphimquocgia.com.vn/Content/Image/banner.jpg"),
(2,"CGV Vincom Royal City", "30", "20", "10", "Vincom Mega Mall, 72A Đ. Nguyễn Trãi, Khu đô thị Royal City, Thanh Xuân, Hà Nội", "https://statics.vincom.com.vn/vincom-ho/brand/cgv/cgv01.jpeg"),
(3,"LOTTE CINEMA LANDMARK", "30", "20", "10", "Tòa Nhà Kaengnam Hà Nội Landmark Tower, E6, Phạm Hùng, Mỹ Đình, Cầu Giấy, Hà Nội", "https://www.wonderlandvietnam.com.vn/image/catalog/land/lotte-cinema-keangnam(5).jpg"),
(4,"CGV Su Van Hanh", "30", "20", "10", "Tầng 6, Vạn Hạnh Mall, 11 Đ. Sư Vạn Hạnh, Phường 12, Quận 10, Thành phố Hồ Chí Minh", "https://iguov8nhvyobj.vcdn.cloud/media/site/cache/1/980x415/b58515f018eb873dafa430b6f9ae0c1e/v/h/vhm-1.png"),
(5,"Diamond Cinema", "30", "20", "10", "Tầng 13, Diamond Plaza, 34 Đ. Lê Duẩn, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh", "https://thegioidienanh.vn/stores/news_dataimages/phuonght/122016/12/09/5030_LC_Diamond_Prestige_3.jpg"),
(6,"MegaStar Cineplex Hung Vuong Plaza", "30", "20", "10", "126 Hùng Vương, Tích Sơn, Vĩnh Yên, Vĩnh Phúc", "https://www.primevn.com/upload/1/products/l_487507015_productimage_s112.jpg")
ON DUPLICATE KEY UPDATE
    theater_name = VALUES(theater_name);
