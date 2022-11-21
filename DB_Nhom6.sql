create database DA1_PTPM_IT17327_Nhom6
use DA1_PTPM_IT17327_Nhom6
drop database DA1_PTPM_IT17327_Nhom6

create table xe(

	id uniqueidentifier primary key,
	ten nvarchar(50) 
)

insert into xe(id) values(newid())

create table loaiXe(

	id uniqueidentifier primary key,
	ma nvarchar(50),
	ten nvarchar(50),
)

insert into loaiXe(id) values(newid())

create table phieuBaoDuong(

	id uniqueidentifier primary key,
	idXe uniqueidentifier,
	ngayBaoDuong date,
	ngayHoanThanh date,
	chiPhi float
)

insert into phieuBaoDuong(id, ngayBaoDuong, ngayHoanThanh, chiPhi, bienSoXe) 
values(newid(), '2022-11-19', '2022-11-22', 500000, 'H0123456')

select * from phieuBaoDuong

delete from phieuBaoDuong where id = '3B99E685-EF71-4EFF-875A-A90FC416F222' 

alter table phieuBaoDuong 
add bienSoXe varchar(50) 

alter table phieuBaoDuong 
drop column idXe

select id, ngayBaoDuong, ngayHoanThanh, chiPhi, bienSoXe 
from phieuBaoDuong where bienSoXe = ?

update phieuBaoDuong
set ngayBaoDuong = ?, ngayHoanThanh = ?, chiPhi = ?, bienSoXe = ?
where phieuBaoDuong.id = ?

create table chucVu(

	id uniqueidentifier primary key,
	ten nvarchar(50)
)

create table chiTietXe(

	id uniqueidentifier primary key,
	idXe uniqueidentifier foreign key references xe(id),
	idLoai uniqueidentifier foreign key references loaiXe(id),
	idPhieu uniqueidentifier foreign key references phieuBaoDuong(id),
	giaNhap float,
	tinhTrangXe int,
	bienSo nvarchar(50),
)

select * from chiTietXe

create table nhanVien(

	id uniqueidentifier primary key,
	ten nvarchar(50),
	ngaySinh date,
	sdt nvarchar(50),
	gioiTinh bit,
	idChucVu uniqueidentifier foreign key references chucVu(id)
)

create table khachHang(

	id uniqueidentifier primary key,
	ten nvarchar(50),
	sdt nvarchar(50),
	gioiTinh bit,
	cCCD nvarchar(50)
)

create table hopDong(

	id uniqueidentifier primary key,
	idNv uniqueidentifier foreign key references nhanVien(id),
	idKh uniqueidentifier foreign key references khachHang(id),
	ngayTao date,
	ngayHetHan date,
	tinhTrang int
)

create table hoaDonHoanTra(

	id uniqueidentifier primary key,
	idKh uniqueidentifier foreign key references khachHang(id),
	idHopDong uniqueidentifier foreign key references hopDong(id),
	ngayTra date,
	donGia float,
	soLuong int,
	tinhTrang int,
	phiPhatSinh float
)

create table chiTietHopDong(

	idHopDong uniqueidentifier foreign key references hopDong(id),
	idXe uniqueidentifier foreign key references chiTietXe(id),
	donGia float,
	soLuong int,
	tienCoc float,
	primary key (idHopDong,idXe)
)
