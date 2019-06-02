-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 02, 2019 at 04:34 PM
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
-- Database: `ta`
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
(1, '2019-05-26', '09:00:00', '21:00:00', 1),
(2, '2019-05-27', '02:00:00', '04:00:00', 1),
(3, '2019-07-04', '23:00:00', '04:00:00', 1),
(4, '2019-05-28', '23:00:00', '02:59:00', 1),
(5, '2019-05-26', '04:00:00', '09:00:00', 1),
(6, '2019-06-18', '04:00:00', '05:00:00', 1),
(7, '2019-05-31', '08:00:00', '09:00:00', 2),
(8, '2019-05-30', '04:00:00', '08:00:00', 2),
(9, '2019-05-30', '08:00:00', '09:00:00', 2),
(10, '2019-05-31', '14:00:00', '15:00:00', 1),
(11, '2019-06-07', '04:00:00', '05:00:00', 2),
(12, '2019-05-31', '04:00:00', '05:00:00', 2),
(13, '2019-05-01', '11:00:00', '12:00:00', 2);

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
(1, 'Luka Luar', 3),
(2, 'Bedah', 1),
(3, 'Periksa Biasa', 7);

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
(1, 'Penahan Rasa Sakit', 'Reagen', 54, 'Paracetamol'),
(2, 'Reagen Khusus', 'Reagen', 6, 'Metanol'),
(3, 'Untuk membersihkan luka', 'Obat Luar', 1, 'Iodium'),
(4, 'Hanya Untuk Diluar', 'Obat Luar', 5, 'Betadine'),
(5, 'Menambah Stamina', 'Reagen', 2, 'Bodigizer'),
(6, 'Ekstra Stamina', 'Reagen', 5, 'Turbojolt'),
(7, 'Obat Kuat', 'Reagen', 6, 'Bodigizer XL'),
(8, 'Obat Super Kuat', 'Reagen', 6, 'Turbojolt XL'),
(9, 'Obat Aneh', 'Reagen', 11, 'Blue Drugs'),
(10, 'Apel terbaik dari mineral town', 'Reagen', 99, 'Super Ultra Great Delicious Wonderful Apple');

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
(1, 'Ibnu'),
(2, 'Desti'),
(3, 'Nana');

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
(1, NULL, 3, '2019-05-23', '2019-05-09', 11, 1, 1),
(2, '', 3, '2019-05-28', '2019-05-27', 2, 1, 1),
(4, NULL, 2, '2019-05-30', '2019-05-25', 2, 1, 2),
(6, NULL, 2, '2019-05-30', '2019-05-28', 1, 1, 3),
(7, NULL, 1, '2019-05-29', '2019-05-28', 3, 3, 3),
(8, NULL, 2, '2019-06-02', '2019-05-22', 2, 2, 1);

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
(1, 'Riyadi Setiawan'),
(2, 'Ibnu');

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
(2, '$2a$10$diOADw11SKQ8fVxfNJrjJ.pi27XW6GURvRHR5hC3NJrUwzBuJ1vCC', 'admin_lab', 'rostiawan'),
(3, '$2a$10$bfEUSVYZocX29.GU9y4bge9eZjqbysihEBIWkd97tdYlXqWhIaYX6', 'staff_lab', 'desti'),
(4, '$2a$10$LhIxTUzEgE3DZKh5iwWyvuQUHBiOIXsK0uh6N1AJKdm2dOSWkDmYO', 'admin_lab', 'adminlab'),
(5, '$2a$10$Y6tPUqe7qFsIVUiIlDsQtOrllaIDuAdQ8faJWMaUkr6HpGFprRzXe', 'staff_lab', 'stafflab');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `jenis_pemeriksaan`
--
ALTER TABLE `jenis_pemeriksaan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `kebutuhan_reagen`
--
ALTER TABLE `kebutuhan_reagen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lab_supplies`
--
ALTER TABLE `lab_supplies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pasien`
--
ALTER TABLE `pasien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
