create database DA1_PTPM_IT17327_Nhom6
use DA1_PTPM_IT17327_Nhom6
drop database DA1_PTPM_IT17327_Nhom6

create table loaiXe(
	id uniqueidentifier primary key,
	ma nvarchar(50),
	ten nvarchar(50),
	giaNhap float,
	giaThue float,
)

create table phieuBaoDuong(
	id uniqueidentifier primary key,
	idXe uniqueidentifier,
	ngayBaoDuong date,
	ngayHoanThanh date,
	chiPhi float
)

create table chiTietXe(
	bienSo nvarchar(50) primary key,
	idLoai uniqueidentifier foreign key references loaiXe(id),
	idPhieu uniqueidentifier foreign key references phieuBaoDuong(id),
	tinhTrangXe int,
	
)

create table nhanVien(
	id uniqueidentifier primary key,
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
)

create table hopDong(
	id uniqueidentifier primary key,
	idNv uniqueidentifier foreign key references nhanVien(id),
	idKh uniqueidentifier foreign key references khachHang(id),
	ngayTao date,
	ngayHetHan date,
	tinhTrang int
)

create table hoaDonTraXe(
	id uniqueidentifier primary key,
	idKh uniqueidentifier foreign key references khachHang(id),
	idHopDong uniqueidentifier foreign key references hopDong(id),
	ngayTra date,
	soLuong int,
	tinhTrang int, --0 chưa,1 hoàn thành
	phiPhatSinh float,
	thanhTien float,
)

create table chiTietHopDong(
	idHopDong uniqueidentifier foreign key references hopDong(id),
	bienSo nvarchar(50) foreign key references chiTietXe(bienSo),
	tienCoc float,
	primary key (idHopDong,bienSo) 
)
select * from nhanVien
select * from khachHang
insert into nhanVien values(newid(),N'hoàng văn b','2000-1-1','0978237842873',0,N'nhân viên')
insert into khachHang values(newid(),'abcdxyz',N'Nguyễn Văn a','0323423534',0,'2367842867347862')
insert into hopDong values(newid(),'C147D902-124D-48F7-91AE-77565EA30CEC','05CDD12F-AEAA-45FD-A467-2BAB68FDFC58','2021-11-1','2022-2-1',0)