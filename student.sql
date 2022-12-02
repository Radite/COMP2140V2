-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 24, 2019 at 11:43 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--
create database student;
use student;

CREATE TABLE `admin` (
  `ID` int(20) NOT NULL,
  `Username` varchar(10) NOT NULL,
  `Password` varchar(8) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ID`, `Username`, `Password`) VALUES
(1, 'Admin', '1234');

-- --------------------------------------------------------


-- --------------------------------------------------------

--
-- Table structure for table `signupdata`
--

CREATE TABLE `signupdata` (
  `ID` int(20) NOT NULL,
  `Username` varchar(10) NOT NULL,
  `MailID` varchar(20) NOT NULL,
  `Password` varchar(8) NOT NULL,
  `ConformPassword` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `signupdata`
--

INSERT INTO `signupdata` (`ID`,`Username`, `MailID`, `Password`, `ConformPassword`) VALUES
('159','159', 'test@gmail.com', '12345', '12345');

-- --------------------------------------------------------

CREATE TABLE `signindata` (
  `ID` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `signindata` (`ID`) VALUES
('1');

--
-- Table structure for table `studentinfo`
--

CREATE TABLE `studentinfo` (
  `ID` int(20) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `MobileNo` varchar(10) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `FatherName` varchar(10) NOT NULL,
  `MotherName` varchar(20) NOT NULL,
  `DOB` date NOT NULL,
  `Age` int(2) NOT NULL,
  `Course1` varchar(10) NOT NULL,
  `Course2` varchar(10) NOT NULL,
  `Course3` varchar(15) NOT NULL,
  `Course4` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentinfo`
--

INSERT INTO `studentinfo` (`ID`, `Name`, `MobileNo`, `Gender`, `FatherName`, `MotherName`, `DOB`, `Age`, `Course1`, `Course2`, `Course3`, `Course4`) VALUES
(159, 'test user', '1234567890', 'male', 'test father', 'test mother', '2002-06-15', 20, 'Math', 'English', 'ICT', 'Physics');

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `ID` int(20) NOT NULL,
  `Math` int(20) NOT NULL,
  `English` int(20) NOT NULL,
  `ICT` int(20) NOT NULL,
  `Physics` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`ID`, `Math`, `English`, `ICT`, `Physics`) VALUES
(159,  '50', '85', '72', '42');

CREATE TABLE `teacher` (
  `ID` int(20) NOT NULL,
  `Username` varchar(10) NOT NULL,
  `Password` varchar(8) NOT NULL,
   `ConformPassword` varchar(8) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `teacher` (`ID`, `Username`, `Password`, `ConformPassword`) VALUES
(1, 'Teacher', '1234','1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID`);
  
  ALTER TABLE `teacher`
  ADD PRIMARY KEY (`ID`);
--
-- Indexes for table `admin`
--
ALTER TABLE `signupdata`
  ADD PRIMARY KEY (`ID`);
  
  ALTER TABLE `signindata`
  ADD PRIMARY KEY (`ID`);
  
  

--
-- Indexes for table `studentinfo`
--
ALTER TABLE `studentinfo`
  ADD PRIMARY KEY (`ID`);

-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD PRIMARY KEY (`ID`);
--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
  
  

ALTER TABLE `signindata`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `studentinfo`
--
ALTER TABLE `studentinfo`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=160;
  
--
-- AUTO_INCREMENT for table `marks`
--
ALTER TABLE `marks`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=160;
COMMIT;

ALTER TABLE `teacher`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

  
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
