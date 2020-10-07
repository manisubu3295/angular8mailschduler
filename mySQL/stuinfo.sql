-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 07, 2020 at 11:52 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stuinfo`
--

-- --------------------------------------------------------

--
-- Table structure for table `sdudetails`
--

CREATE TABLE `sdudetails` (
  `id` int(7) NOT NULL,
  `student_name` varchar(8) DEFAULT NULL,
  `student_email` varchar(20) DEFAULT NULL,
  `section` varchar(1) DEFAULT NULL,
  `subjects` varchar(250) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sdudetails`
--

INSERT INTO `sdudetails` (`id`, `student_name`, `student_email`, `section`, `subjects`, `dob`, `gender`) VALUES
(1, 'w', 'w', 'E', '[{name=sevele}]', '2020-10-05', 'Female'),
(2, 'test', 'test', 't', 'test', NULL, 'tes'),
(3, 'sefsfss', 'dsvsdv', 's', 'dsdv', 'sfsdv', 'sdvsdv'),
(4, 'seee', 'rrrrrr', 'r', 'lllll', 'sfsdv', 'pppp'),
(5, '1234848', 'jfuufkk', 'o', 'loitj', 'lookfkf', 'lrooffkfk'),
(6, 'oiuy', 'iuuu', 'i', 'ouuu', 'ooooi', 'oooii'),
(7, 'divya', 'divya@gmail.com', 'A', '[{name=divu}]', '2020-10-05', 'Female'),
(8, 'Navya', 'navya@gmail.com', 'B', '[{name=english}]', '2020-09-30', 'Female'),
(9, 'divu', 'divu@gmail.com', 'A', '[{name=as}]', '2020-10-02', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sdudetails`
--
ALTER TABLE `sdudetails`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sdudetails`
--
ALTER TABLE `sdudetails`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
