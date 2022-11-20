create database DA1_PTPM_IT17327_Nhom6
use DA1_PTPM_IT17327_Nhom6
drop database DA1_PTPM_IT17327_Nhom6

create table xe(

	id uniqueidentifier default newid() primary key,
	ma nvarchar(50),
	ten nvarchar(50) 
)
insert into xe(ma,ten) values ('Xe1',N'Cx5')

create table loaiXe(
	id uniqueidentifier default newid() primary key,
	ma nvarchar(50),
	ten nvarchar(50),
)
insert into loaixe(ma,ten) values ('LX1',N'Siu xe')
select*from loaixe
create table phieuBaoDuong(

	id uniqueidentifier primary key,
	idXe uniqueidentifier,
	ngayBaoDuong date,
	ngayHoanThanh date,
	chiPhi float
)

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
	ngayNhap nvarchar(100),
	tinhTrangXe int,
	bienSo nvarchar(50),
)

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
	idHoaDon uniqueidentifier foreign key references hopDong(id),
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
