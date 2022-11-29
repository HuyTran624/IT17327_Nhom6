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




insert into khachHang values(newid(),'abcdxyz',N'Nguyễn Văn a','0323423534',0,'2367842867347862')
insert into hopDong values(newid(),'C147D902-124D-48F7-91AE-77565EA30CEC','05CDD12F-AEAA-45FD-A467-2BAB68FDFC58','2021-11-1','2022-2-1',0)