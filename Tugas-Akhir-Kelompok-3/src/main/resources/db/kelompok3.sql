-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2019 at 03:18 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kelompok3`
--

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_jaga`
--

CREATE TABLE `jadwal_jaga` (
  `id` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `waktu_mulai` time NOT NULL,
  `waktu_selesai` time NOT NULL,
  `id_staff` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jadwal_jaga`
--

INSERT INTO `jadwal_jaga` (`id`, `tanggal`, `waktu_mulai`, `waktu_selesai`, `id_staff`) VALUES
(1, '2019-05-27', '10:00:00', '20:00:00', 1),
(2, '2019-05-27', '06:00:00', '09:00:00', 2),
(3, '2019-05-28', '23:00:00', '04:00:00', 3),
(4, '2019-05-28', '23:00:00', '02:00:00', 4),
(5, '2019-05-29', '07:00:00', '12:00:00', 5),
(6, '2019-05-30', '04:00:00', '17:00:00', 3),
(7, '2019-05-31', '08:00:00', '09:00:00', 2),
(8, '2019-05-31', '05:00:00', '08:00:00', 1),
(9, '2019-06-01', '03:00:00', '09:00:00', 2),
(10, '2019-06-01', '11:00:00', '16:00:00', 4);

-- --------------------------------------------------------

--
-- Table structure for table `jenis_pemeriksaan`
--

CREATE TABLE `jenis_pemeriksaan` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `id_supplies` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jenis_pemeriksaan`
--

INSERT INTO `jenis_pemeriksaan` (`id`, `nama`, `id_supplies`) VALUES
(1, 'Hemoglobin metode sahli', 1),
(3, 'Golongan Darah', 2),
(4, 'Malaria / DDR', 1),
(5, 'Kolestrol', 8),
(6, 'Asam Urat', 4),
(7, 'Glukosa urine metode celup', 7),
(8, 'Plano test', 9),
(9, 'GDS dan GDP', 5),
(10, 'Sputum / BTA', 6);

-- --------------------------------------------------------

--
-- Table structure for table `kebutuhan_reagen`
--

CREATE TABLE `kebutuhan_reagen` (
  `id` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `tanggal_update` date NOT NULL,
  `id_reagen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kebutuhan_reagen`
--

INSERT INTO `kebutuhan_reagen` (`id`, `jumlah`, `status`, `tanggal_update`, `id_reagen`) VALUES
(1, 10, 1, '2019-05-26', 1),
(2, 2, 0, '2019-05-27', 1),
(3, 4, 1, '2019-05-27', 6),
(4, 1, 0, '2019-05-28', 7),
(5, 3, 1, '2019-06-02', 2),
(6, 1, 1, '2019-06-02', 7),
(7, 11, 1, '2019-06-02', 9);

-- --------------------------------------------------------

--
-- Table structure for table `lab_supplies`
--

CREATE TABLE `lab_supplies` (
  `id` int(11) NOT NULL,
  `deskripsi` varchar(255) NOT NULL,
  `jenis` varchar(255) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lab_supplies`
--

INSERT INTO `lab_supplies` (`id`, `deskripsi`, `jenis`, `jumlah`, `nama`) VALUES
(1, 'Melindungi luka luar', 'peralatan', 7, 'kasa'),
(2, 'Oksidasi', 'reagen', 4, 'Collins'),
(3, 'Mendengar detak jantung', 'instrumen', 2, 'Stetoskop'),
(4, 'Membantu disabilitas', 'instrumen', 5, 'Kursi Roda'),
(5, 'Membersihkan luka', 'peralatan', 10, 'Kapas'),
(6, 'Salap luka', 'peralatan', 5, 'Suntik'),
(7, 'Menguji kandungan aldehida dan gula', 'reagen', 7, 'Fehling'),
(8, 'Menutup luka', 'peralatan', 6, 'Perban'),
(9, 'Mendeteksi kandungan protein', 'reagen', 11, 'Millon'),
(10, 'Wadah Reagen', 'instrumen', 11, 'Tabung');

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`id`, `nama`) VALUES
(1, 'Lexys'),
(2, 'Reres'),
(3, 'Sry'),
(4, 'Rani'),
(5, 'Nurul'),
(6, 'Devi'),
(7, 'Hesty'),
(8, 'Lili'),
(9, 'Rahma'),
(10, 'Yuyun');

-- --------------------------------------------------------

--
-- Table structure for table `pemeriksaan`
--

CREATE TABLE `pemeriksaan` (
  `id` int(11) NOT NULL,
  `hasil` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `tanggal_pemeriksaan` date DEFAULT NULL,
  `tanggal_pengajuan` date NOT NULL,
  `id_jadwal` int(11) DEFAULT NULL,
  `jenis` int(11) DEFAULT NULL,
  `pasien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pemeriksaan`
--

INSERT INTO `pemeriksaan` (`id`, `hasil`, `status`, `tanggal_pemeriksaan`, `tanggal_pengajuan`, `id_jadwal`, `jenis`, `pasien`) VALUES
(7, '', 2, '2019-06-02', '2019-05-31', 4, 3, 3),
(8, 'Belum ada', 2, '2019-06-05', '2019-06-02', 3, 5, 7),
(9, 'Positif', 3, '2019-06-05', '2019-06-02', 7, 4, 10);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `nama`) VALUES
(1, 'Muharani'),
(2, 'Pertiwi'),
(3, 'Sakinah'),
(4, 'Afrilia'),
(5, 'Thamara');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL,
  `password` longtext NOT NULL,
  `role` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id`, `password`, `role`, `username`) VALUES
(1, '$2a$10$61XHW9F04EDrDTkq7q2IcuZGSQnPTfT8XOGyfIW8X/HEyYV.NViO2', 'ADMIN', 'admin'),
(2, '$2a$10$6txy8SszoNnxAVTygQTzdu38EausDb0quPjvH4iXVHRtw9zc2mTzu', 'admin_lab', 'admin_lab'),
(3, '$2a$10$6txy8SszoNnxAVTygQTzdu38EausDb0quPjvH4iXVHRtw9zc2mTzu', 'staf_lab', 'staf_lab'),
(4, '$2a$10$54dpWTIi3j9mx2Ga8GzY2u58ACtz7A1EPBmv/yDELT6wtjtI//UTG', 'admin_farmasi', 'admin_farmasi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jadwal_jaga`
--
ALTER TABLE `jadwal_jaga`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhpdyv2ej5el1wh47un3s325yl` (`id_staff`);

--
-- Indexes for table `jenis_pemeriksaan`
--
ALTER TABLE `jenis_pemeriksaan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqonpgmn1ert0bqedbqgj8sr0o` (`id_supplies`);

--
-- Indexes for table `kebutuhan_reagen`
--
ALTER TABLE `kebutuhan_reagen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsoblrjuluhvpcy0s8vuwg8ix4` (`id_reagen`);

--
-- Indexes for table `lab_supplies`
--
ALTER TABLE `lab_supplies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8p1b1q057xbqyd5q0ublbm9cx` (`id_jadwal`),
  ADD KEY `FKrxxyvrrnies0ealgbacnvyo8w` (`jenis`),
  ADD KEY `FKax2soysg0ui29t0o8qcln11ug` (`pasien`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jadwal_jaga`
--
ALTER TABLE `jadwal_jaga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `jenis_pemeriksaan`
--
ALTER TABLE `jenis_pemeriksaan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `kebutuhan_reagen`
--
ALTER TABLE `kebutuhan_reagen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `lab_supplies`
--
ALTER TABLE `lab_supplies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pasien`
--
ALTER TABLE `pasien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jadwal_jaga`
--
ALTER TABLE `jadwal_jaga`
  ADD CONSTRAINT `FKhpdyv2ej5el1wh47un3s325yl` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `jenis_pemeriksaan`
--
ALTER TABLE `jenis_pemeriksaan`
  ADD CONSTRAINT `FKqonpgmn1ert0bqedbqgj8sr0o` FOREIGN KEY (`id_supplies`) REFERENCES `lab_supplies` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `kebutuhan_reagen`
--
ALTER TABLE `kebutuhan_reagen`
  ADD CONSTRAINT `FKsoblrjuluhvpcy0s8vuwg8ix4` FOREIGN KEY (`id_reagen`) REFERENCES `lab_supplies` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD CONSTRAINT `FK8p1b1q057xbqyd5q0ublbm9cx` FOREIGN KEY (`id_jadwal`) REFERENCES `jadwal_jaga` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKax2soysg0ui29t0o8qcln11ug` FOREIGN KEY (`pasien`) REFERENCES `pasien` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKrxxyvrrnies0ealgbacnvyo8w` FOREIGN KEY (`jenis`) REFERENCES `jenis_pemeriksaan` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
