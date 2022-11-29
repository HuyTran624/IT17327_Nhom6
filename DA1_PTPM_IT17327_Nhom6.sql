create database DA1_PTPM_IT17327_Nhom6
use DA1_PTPM_IT17327_Nhom6
drop database DA1_PTPM_IT17327_Nhom6

create table loaiXe(
	maLx nvarchar(50)primary key,
	ten nvarchar(50),
	giaNhap float,
	giaThue float,
)

create table phieuBaoDuong(
	id uniqueidentifier primary key,
	bienSo nvarchar(50) foreign key references chiTietXe(bienSo),
	ngayBaoDuong date,
	ngayHoanThanh date,
	chiPhi float
)

create table chiTietXe(
	bienSo nvarchar(50) primary key,
	maLx nvarchar(50) foreign key references loaiXe(maLx),
	tinhTrangXe int,
	TrangThai int,
	TinhTrang int,
	giathuetrenngay money,
)
drop table nhanVien;
create table nhanVien(
	idnv nvarchar(50) primary key,
	ten nvarchar(50),
	ngaySinh date,
	sdt nvarchar(50),
	gioiTinh bit,
	chucVu nvarchar(50)
)


create table khachHang(
	id uniqueidentifier primary key,
	maKH nvarchar(50),
	ten nvarchar(50),
	sdt nvarchar(50),
	gioiTinh bit,
	cCCD nvarchar(50),
	email nvarchar(50)
)

create table hopDong(
	id uniqueidentifier primary key,
	idNv nvarchar(50) foreign key references nhanVien(idnv),
	idKh uniqueidentifier foreign key references khachHang(id),
	ngayTao date,
	ngayHetHan date,
	tinhTrang int,
	sourceAnh nvarchar(50),
	mahopdong nvarchar(50)
)
create table BienBan(
	mavipham int primary key,
	ten nvarchar(50),
	
)
create table hoaDonTraXe(
	id uniqueidentifier primary key,
	idKh uniqueidentifier foreign key references khachHang(id),
	idHopDong uniqueidentifier foreign key references hopDong(id),
	ngayTra date,
	soLuong int,
	mavipham int foreign key references BienBan(mavipham),
	phiPhatSinh float,
	thanhTien float,
	sourceAnh nvarchar(50)
)

create table chiTietHopDong(
	idHopDong uniqueidentifier foreign key references hopDong(id),
	bienSo nvarchar(50) foreign key references chiTietXe(bienSo),
	tienCoc float,
	primary key (idHopDong,bienSo) 
)
select * from nhanVien
select * from khachHang
insert into nhanVien values('NV1',N'Nguyễn Mạnh Hà','2003-11-04','0857595060',0,N'Nhân Viên')
insert into nhanVien values('NV2',N'Nguyễn Hữu Bình','2003-11-28','01234567733',0,N'Nhân Viên')
insert into nhanVien values('NV3',N'Nguyễn Ngọc Minh','2003-11-04','09789238455',0,N'Quản Lý')
insert into nhanVien values('NV4',N'Nguyễn Việt Anh','2003-11-04','09723847572',0,N'Nhân Viên')
insert into nhanVien values('NV5',N'Hoàng Việt Dũng','2003-11-04','06823847923',0,N'Nhân Viên')
insert into nhanVien values('NV6',N'Nguyễn Trung Anh','2003-11-04','02837692352',0,N'Nhân Viên')
insert into nhanVien values('NV7',N'Trần Ngọc Huy','2003-11-04','06236365313',0,N'Nhân Viên')



insert into khachHang values(newid(),'KH1',N'Nguyễn Mạnh Hà','0323423534',0,'01245672','hanmph27977@fpt.edu.vn')
insert into khachHang values(newid(),'KH2',N'Nguyễn Văn An','0125121451',0,'01153472','mailtest@gmail.com')
insert into khachHang values(newid(),'KH3',N'Trần Hữu Nam','0125156123',0,'04325642','mailtest@gmail.com')
insert into khachHang values(newid(),'KH4',N'Nguyễn Hữu Bình','0678967845',0,'01346372','mailtest@gmail.com')
insert into khachHang values(newid(),'KH5',N'Hoàng Việt Dũng','0456783452',0,'01256312','otosakayuu203@gmail.com')
insert into khachHang values(newid(),'KH6',N'Hoàng Thùy Chi','0345728956',1,'04574435','dunghvph28012@fpt.edu.vn')
insert into khachHang values(newid(),'KH7',N'Nguyễn Long Nam','0351674588',0,'04568456','mailtest@gmail.com')
insert into khachHang values(newid(),'KH8',N'Bùi Thị Kim Anh','0567846756',1,'02367245','mailtest@gmail.com')
insert into khachHang values(newid(),'KH9',N'Phan Công Văn','0679456312',0,'03467234','mailtest@gmail.com')
insert into khachHang values(newid(),'KH10',N'Nam Thái Sơn','0456867934',0,'01234624','mailtest@gmail.com')
insert into khachHang values(newid(),'KH11',N'Hoàng Thùy Linh','0457834535',1,'01234624','mailtest@gmail.com')
insert into khachHang values(newid(),'KH12',N'Nguyễn Quỳnh Chi','097684254',1,'01234624','mailtest@gmail.com')
insert into khachHang values(newid(),'KH13',N'Nguyễn Văn An','064567456',0,'03647345','mailtest@gmail.com')
insert into khachHang values(newid(),'KH14',N'Nguyễn Văn Thái','0345572341',0,'02356234','mailtest@gmail.com')
insert into khachHang values(newid(),'KH15',N'Nguyễn Nam Kim','0125612452',0,'09678576','mailtest@gmail.com')
insert into khachHang values(newid(),'KH16',N'Trần Kim Sắc','0123456789',0,'04568256','anhntph28042@fpt.edu.vn')
insert into khachHang values(newid(),'KH17',N'Lục Văn Dũng','0987654321',0,'05683455','mailtest@gmail.com')
insert into khachHang values(newid(),'KH18',N'Lê Tuấn Phong','0112233445',0,'02362347','huytnph27916@fpt.edu.vn')
insert into khachHang values(newid(),'KH19',N'Kiều Hoàng Mai','0556677889',1,'03456734','mailtest@gmail.com')
insert into khachHang values(newid(),'KH20',N'Phan Quốc Huy','0125756781',0,'03451364','mailtest@gmail.com')
insert into khachHang values(newid(),'KH21',N'Nguyễn Kim An','0345734513',0,'01235624','mailtest@gmail.com')
insert into khachHang values(newid(),'KH22',N'Trần Quốc Bảo','0457456524',0,'03467345','mailtest@gmail.com')
insert into khachHang values(newid(),'KH23',N'Hoàng Mạnh Cường','0346716878',0,'06578567','mailtest@gmail.com')
insert into khachHang values(newid(),'KH24',N'Nguyễn Thái Bình','01234564832',0,'02367345','mailtest@gmail.com')
insert into khachHang values(newid(),'KH25',N'Trần Văn Nam','09847894586',0,'04563452','mailtest@gmail.com')
insert into khachHang values(newid(),'KH26',N'Lê Thị Nga','045674568322',1,'06458865','mailtest@gmail.com')
insert into khachHang values(newid(),'KH27',N'Nguyễn Việt Anh','0333675875',0,'04567345','mailtest@gmail.com')
insert into khachHang values(newid(),'KH28',N'Trần Ngọc Huy','0856668563',0,'03456234','huytranisdabest@gmail.com')
insert into khachHang values(newid(),'KH29',N'Đỗ Thành Cường','04567345734',1,'03457234','mailtest@gmail.com')
insert into khachHang values(newid(),'KH30',N'Nguyễn Trung Anh','08746584588',0,'01561235','nguyentrunganhnta43@gmail.com')

insert into hopDong values(newid(),'C147D902-124D-48F7-91AE-77565EA30CEC','05CDD12F-AEAA-45FD-A467-2BAB68FDFC58','2021-11-1','2022-2-1',0)