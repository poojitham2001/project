-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 30, 2022 at 10:53 AM
-- Server version: 5.6.50
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flight_ticket_booking`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_title` varchar(255) NOT NULL,
  `category_description` varchar(255) NOT NULL,
  `category_image` longblob,
  `category_image_filename` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_title`, `category_description`, `category_image`, `category_image_filename`) VALUES
(1, 'International', 'International Flights', NULL, '1656510007_Domestic-Flights.jpeg'),
(2, 'Domestic', 'Domestic Flights', NULL, '1656510044_Air-India-Boeing-787-8-Dreamliner-VT-ANL-3-25-19-William-Derrickson-1920x1280.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `city_id` int(10) UNSIGNED NOT NULL,
  `city_name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`city_id`, `city_name`) VALUES
(1, 'Mumbai'),
(2, 'Delhi'),
(3, 'Chenai'),
(4, 'Banglore'),
(5, 'Varanasi'),
(6, 'Kolkatta'),
(7, 'Ghaziabad'),
(8, 'Aligarh'),
(9, 'Tundal'),
(10, 'Kanpur'),
(11, 'Allahabad'),
(12, 'Mirzapur'),
(13, 'Mughalsarai'),
(14, 'Bhabua Road'),
(15, 'Sasaram'),
(16, 'Gaya'),
(17, 'Howrah'),
(18, 'Kodarma'),
(19, 'Asansol'),
(20, 'Dhanbad');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `company_id` int(11) NOT NULL,
  `company_title` varchar(255) NOT NULL,
  `company_description` text NOT NULL,
  `company_image` longblob,
  `company_image_filename` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`company_id`, `company_title`, `company_description`, `company_image`, `company_image_filename`) VALUES
(1, 'Air India', 'To make students well-versed with Joint Entrance Exam (JEE), ETOOSINDIA brings you the complete IIT JEE Syllabus 2021-2022 to start your preparation. JEE consists of JEE Main and JEE Advanced paper offering admissions to BE/B.Tech & B.Arch/B.Plan companys. The exam is a gateway to get into renowned IITs, NITs, IITs, CFTIs, other engineering & architecture colleges in India. The syllabus comprises of subjects Physics, Chemistry & Mathematics. Students need to cover the entire syllabus well-in time to crack this prestigious exam. So, begin you your preparation for JEE 2021-2022 with ETOOSINDIA. The updated syllabus is mentioned below.\r\n\r\n', NULL, '1656510007_Domestic-Flights.jpeg'),
(2, 'Air France', 'To make students well-versed with Joint Entrance Exam (JEE), ETOOSINDIA brings you the complete IIT JEE Syllabus 2021-2022 to start your preparation. JEE consists of JEE Main and JEE Advanced paper offering admissions to BE/B.Tech & B.Arch/B.Plan companys. The exam is a gateway to get into renowned IITs, NITs, IITs, CFTIs, other engineering & architecture colleges in India. The syllabus comprises of subjects Physics, Chemistry & Mathematics. Students need to cover the entire syllabus well-in time to crack this prestigious exam. So, begin you your preparation for JEE 2021-2022 with ETOOSINDIA. The updated syllabus is mentioned below.\r\n\r\n', NULL, '1656510007_Domestic-Flights.jpeg'),
(3, 'Indigo', 'To make students well-versed with Joint Entrance Exam (JEE), ETOOSINDIA brings you the complete IIT JEE Syllabus 2021-2022 to start your preparation. JEE consists of JEE Main and JEE Advanced paper offering admissions to BE/B.Tech & B.Arch/B.Plan companys. The exam is a gateway to get into renowned IITs, NITs, IITs, CFTIs, other engineering & architecture colleges in India. The syllabus comprises of subjects Physics, Chemistry & Mathematics. Students need to cover the entire syllabus well-in time to crack this prestigious exam. So, begin you your preparation for JEE 2021-2022 with ETOOSINDIA. The updated syllabus is mentioned below.\r\n\r\n', NULL, '1656510007_Domestic-Flights.jpeg'),
(4, 'Go Air', 'To make students well-versed with Joint Entrance Exam (JEE), ETOOSINDIA brings you the complete IIT JEE Syllabus 2021-2022 to start your preparation. JEE consists of JEE Main and JEE Advanced paper offering admissions to BE/B.Tech & B.Arch/B.Plan companys. The exam is a gateway to get into renowned IITs, NITs, IITs, CFTIs, other engineering & architecture colleges in India. The syllabus comprises of subjects Physics, Chemistry & Mathematics. Students need to cover the entire syllabus well-in time to crack this prestigious exam. So, begin you your preparation for JEE 2021-2022 with ETOOSINDIA. The updated syllabus is mentioned below.\r\n\r\n', NULL, '1656510007_Domestic-Flights.jpeg'),
(5, 'American Airlines', 'To make students well-versed with Joint Entrance Exam (JEE), ETOOSINDIA brings you the complete IIT JEE Syllabus 2021-2022 to start your preparation. JEE consists of JEE Main and JEE Advanced paper offering admissions to BE/B.Tech & B.Arch/B.Plan companys. The exam is a gateway to get into renowned IITs, NITs, IITs, CFTIs, other engineering & architecture colleges in India. The syllabus comprises of subjects Physics, Chemistry & Mathematics. Students need to cover the entire syllabus well-in time to crack this prestigious exam. So, begin you your preparation for JEE 2021-2022 with ETOOSINDIA. The updated syllabus is mentioned below.\r\n\r\n', NULL, '1656510007_Domestic-Flights.jpeg'),
(6, 'Air Eagle', 'To make students well-versed with Joint Entrance Exam (JEE), ETOOSINDIA brings you the complete IIT JEE Syllabus 2021-2022 to start your preparation. JEE consists of JEE Main and JEE Advanced paper offering admissions to BE/B.Tech & B.Arch/B.Plan companys. The exam is a gateway to get into renowned IITs, NITs, IITs, CFTIs, other engineering & architecture colleges in India. The syllabus comprises of subjects Physics, Chemistry & Mathematics. Students need to cover the entire syllabus well-in time to crack this prestigious exam. So, begin you your preparation for JEE 2021-2022 with ETOOSINDIA. The updated syllabus is mentioned below.\r\n\r\n', NULL, '1656510007_Domestic-Flights.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL,
  `contact_name` varchar(255) NOT NULL,
  `contact_email` varchar(255) NOT NULL,
  `contact_subject` text NOT NULL,
  `contact_message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`contact_id`, `contact_name`, `contact_email`, `contact_subject`, `contact_message`) VALUES
(142, 'Kaushal Kishore', 'kaushal@gmail.com', 'Need to Learn PHP', 'Hello Team, I need to learn PHP'),
(143, 'Amit Kumar', 'amit@gmail.com', 'Need to Learn C', 'Hello Team, I need to learn C Language'),
(146, 'Sumit Singh', 'sumit@gmail.com', 'Need to Learn Angular', 'Hello Team, I need to learn Angular'),
(147, 'Rahul Kumar', 'rahul@gmail.com', 'Need to Learn NodeJS', 'Hello Team, I need to learn NodeJS');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `country_id` int(11) NOT NULL,
  `country_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`country_id`, `country_name`) VALUES
(1, 'India'),
(2, 'USA');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `customer_email` varchar(255) NOT NULL,
  `customer_password` varchar(255) NOT NULL,
  `customer_first_name` varchar(255) NOT NULL,
  `customer_last_name` varchar(255) NOT NULL,
  `customer_dob` varchar(255) NOT NULL,
  `customer_address` varchar(255) NOT NULL,
  `customer_city` varchar(255) NOT NULL,
  `customer_state` varchar(255) NOT NULL,
  `customer_country` varchar(255) NOT NULL,
  `customer_mobile` varchar(255) NOT NULL,
  `customer_nationalty` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `customer_email`, `customer_password`, `customer_first_name`, `customer_last_name`, `customer_dob`, `customer_address`, `customer_city`, `customer_state`, `customer_country`, `customer_mobile`, `customer_nationalty`) VALUES
(1, 'aman@gmail.com', 'test', 'Aman', 'Kumar', '2021-10-15', 'gjhg', 'Mumbai', 'Maharastra', 'India', '9899786756', 'Indian'),
(2, 'sumit@gmail.com', 'test', 'Pawan', 'Kumar', '2021-10-15', 'jhjk', 'Jaipur', 'Rajasthan', 'India', '9878765434', 'jb'),
(3, 'rahul@gmail.com', 'test', 'Rahul', 'Kumar', '2021-10-08', 'jhg', 'Mumbai', 'Mahastra', 'India', '8987676567', 'g'),
(4, 'sumit@gmail.com', 'test', 'Sumit', 'Kumar', '2021-10-16', 'jk', 'Delhi', 'Delhi', 'India', '7689876567', 'kh'),
(5, 'amit@gmail.com', 'test', 'Amit', 'Kumar', '2021-10-26', 'gg1', 'Kanpur', 'Uttar Pradesh', 'India', '9123321289', 'gg1');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `department_id` int(11) NOT NULL,
  `department_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`department_id`, `department_name`) VALUES
(1, 'IT Department'),
(2, 'Java Developement'),
(3, 'HR Department'),
(4, 'Web Developement');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `employee_sal` varchar(100) NOT NULL,
  `employee_first_name` varchar(100) NOT NULL,
  `employee_middle_name` varchar(100) NOT NULL,
  `employee_last_name` varchar(100) NOT NULL,
  `employee_gender` varchar(100) NOT NULL,
  `employee_address` varchar(100) NOT NULL,
  `employee_village` varchar(100) NOT NULL,
  `employee_state` varchar(100) NOT NULL,
  `employee_country` varchar(100) NOT NULL,
  `employee_landline` varchar(100) NOT NULL,
  `employee_mobile` varchar(100) NOT NULL,
  `employee_email` varchar(100) NOT NULL,
  `employee_status` varchar(255) NOT NULL,
  `employee_department` varchar(255) NOT NULL,
  `employee_dob` varchar(255) NOT NULL,
  `employee_nationalty` varchar(255) NOT NULL,
  `employee_qualification` text NOT NULL,
  `employee_history` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `employee_sal`, `employee_first_name`, `employee_middle_name`, `employee_last_name`, `employee_gender`, `employee_address`, `employee_village`, `employee_state`, `employee_country`, `employee_landline`, `employee_mobile`, `employee_email`, `employee_status`, `employee_department`, `employee_dob`, `employee_nationalty`, `employee_qualification`, `employee_history`) VALUES
(1001, '1', 'Amit', 'Kumar', 'Singh', 'Male', 'A : 42/6', 'Ghaziabad', '5', '1', 'Uttar Pradesh', '09876543212', 'kaushal@gmail.com', '2', '1', '2021-07-07', 'Indian', '', ''),
(1002, '2', 'Kaushal', 'Kishore', 'Jaiswal', 'Male', 'A : 42/6', 'Ghaziabad', 'sdfgsdfg', '1', '89273458', '09876543212', 'kaushal.rahuljaiswal@gmail.com', '1', '3', '2021-08-31', 'Indian', 'qwrqwer', 'qwreqwer'),
(1003, '1', 'Sumit', 'Kumar', 'Aggarwal', 'Male', 'A : 42/6', 'Ghaziabad', '1', '1', 'Uttar Pradesh', '09876543212', 'kishore@gmail.com', '2', '1', '12 January, 1988', 'Indian', '', ''),
(1014, '1', 'Anuj', 'Kumar', 'Dubej', 'Male', 'A : 42/6 Sector 62', 'Bhabua (Kaimur)', '1', '1', '9876543212', '9876543212', 'anuj@gmail.com', '1', '1', '12 January 1985', 'Indian', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL,
  `feedback_name` varchar(255) NOT NULL,
  `feedback_email` varchar(255) NOT NULL,
  `feedback_message` text NOT NULL,
  `feedback_rating` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`feedback_id`, `feedback_name`, `feedback_email`, `feedback_message`, `feedback_rating`) VALUES
(1, 'Amit Singh', 'amit@gmail.com', 'Good Website', '5'),
(2, 'Sumit Singh', 'sumit@gmail.com', 'Best Website', '4'),
(3, 'Ranjeet Singh', 'ranjeet@gmail.com', 'Good contents for students', '5'),
(148, 'Aman', 'aman@gmail.com', 'Informative Website', '5');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(377);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `login_id` int(11) NOT NULL,
  `login_employee_id` varchar(255) NOT NULL,
  `login_email` varchar(255) NOT NULL,
  `login_password` varchar(255) NOT NULL,
  `login_level_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`login_id`, `login_employee_id`, `login_email`, `login_password`, `login_level_id`) VALUES
(1, '1001', 'admin', 'test', '1'),
(2, '1002', 'employee', 'test', '2'),
(37, '36', 'hh', 'hh', '2'),
(39, '38', 'hh', 'hh', '1'),
(41, '40', 'hh', 'hh', '2'),
(43, '42', 'hh', 'hh', '2'),
(45, '44', 'hh', 'hh', '1'),
(47, '46', 'hh', 'hh', '1'),
(49, '48', 'jj', 'jj', '1'),
(51, '50', 'hh', 'hh', '1'),
(53, '52', 'hh', 'hh', '2'),
(55, '54', 'hh', 'hh', '1'),
(57, '56', 'hh', 'hh', '2'),
(59, '58', 'hhh', 'hh', '1'),
(61, '60', 'admin1', 'test', '1'),
(100, '99', 'uu', 'uu', '2'),
(102, '101', 'jjj', 'jj', '1'),
(104, '103', 'xx', 'xx', '1');

-- --------------------------------------------------------

--
-- Table structure for table `month`
--

CREATE TABLE `month` (
  `month_id` int(11) NOT NULL,
  `month_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `month`
--

INSERT INTO `month` (`month_id`, `month_name`) VALUES
(1, 'January'),
(2, 'February'),
(3, 'March'),
(4, 'April'),
(5, 'May'),
(6, 'June'),
(7, 'July'),
(8, 'August'),
(9, 'September'),
(10, 'October'),
(11, 'November'),
(12, 'December');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `order_customer_id` varchar(255) NOT NULL,
  `order_total` varchar(255) NOT NULL,
  `order_status` varchar(255) NOT NULL,
  `order_date` varchar(255) NOT NULL,
  `order_route_id` int(11) NOT NULL,
  `order_travel_date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `order_customer_id`, `order_total`, `order_status`, `order_date`, `order_route_id`, `order_travel_date`) VALUES
(334, '5', '5100', 'Paid', '29 Jun 2022 12:33 AM', 2, '2022-06-30'),
(338, '5', '1700', 'Paid', '29 Jun 2022 12:46 AM', 3, '2022-06-30'),
(343, '5', '3000', 'Paid', '29 Jun 2022 06:54 PM', 4, '2022-06-29'),
(347, '5', '6000', 'Paid', '29 Jun 2022 07:00 PM', 5, '2022-07-01'),
(353, '5', '3400', 'Paid', '30 Jun 2022 03:14 PM', 6, '2022-07-08'),
(365, '5', '1700', 'Paid', '30 Jun 2022 03:15 PM', 2, '2022-07-08'),
(368, '5', '3400', 'Paid', '30 Jun 2022 03:20 PM', 3, '2022-06-30'),
(372, '5', '3400', 'Paid', '30 Jun 2022 03:21 PM', 7, '2022-07-08'),
(375, '5', '1500', 'Paid', '30 Jun 2022 04:16 PM', 8, '2022-07-07');

-- --------------------------------------------------------

--
-- Table structure for table `passengar`
--

CREATE TABLE `passengar` (
  `passengar_id` int(11) NOT NULL,
  `passengar_booking_id` varchar(255) NOT NULL,
  `passengar_user_id` varchar(255) NOT NULL,
  `passengar_name` text NOT NULL,
  `passengar_age` varchar(255) NOT NULL,
  `passengar_gender` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `passengar`
--

INSERT INTO `passengar` (`passengar_id`, `passengar_booking_id`, `passengar_user_id`, `passengar_name`, `passengar_age`, `passengar_gender`) VALUES
(314, '313', '5', 'asdf', 'asdsfs', 'Female'),
(315, '313', '5', '1', '2', 'Male'),
(316, '313', '5', '11', '22', 'Male'),
(317, '313', '5', 'asdf', 'asfdasf', 'Female'),
(318, '313', '5', 'asdf', 'asdf', 'Female'),
(319, '313', '5', 'asdf', 'asdf', 'Female'),
(320, '313', '5', 'asf', 'asdf', 'Female'),
(322, '321', '5', '1', '2', 'Male'),
(323, '321', '5', '3', '5', 'Male'),
(324, '321', '5', '12', '5', 'Female'),
(325, '321', '5', 'asdf', '345', 'Female'),
(335, '334', '5', 'p1', '1', 'Male'),
(336, '334', '5', 'p2', '3', 'Male'),
(337, '334', '5', 'p3', '3', 'Female'),
(339, '338', '5', 'Amit Kumar', '12', 'Male'),
(342, '340', '5', '1', '4', 'Male'),
(345, '343', '5', 'Kaushal Kishore', '12', 'Male'),
(346, '343', '5', 'Atul Kumar', '34', 'Male'),
(349, '347', '5', 'Pass 1', '10', 'Female'),
(350, '347', '5', 'Pass 2', '10', 'Male'),
(351, '347', '5', 'Pass 3', '10', 'Male'),
(352, '347', '5', 'Pass 4', '45', 'Female'),
(363, '353', '5', 'Kaushal Kishore', '12', 'Male'),
(364, '353', '5', '12', '12', 'Male'),
(367, '365', '5', 'Kaaushall', '345', 'Male'),
(370, '368', '5', 'asd', '23', 'Female'),
(371, '368', '5', '2', '32', 'Male'),
(373, '372', '5', '233', '32', 'Male'),
(374, '372', '5', 'sadf', '34', 'Male'),
(376, '375', '5', 'Passs 1', '12', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `payment_customer_id` varchar(255) NOT NULL,
  `payment_date` varchar(255) NOT NULL,
  `payment_amount` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_id`, `payment_customer_id`, `payment_date`, `payment_amount`) VALUES
(165, '5', '2021-11-06', '10000'),
(166, '5', '2021-11-06', '15000'),
(167, '5', '2021-11-06', '12000');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `roles_id` int(11) NOT NULL,
  `roles_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`roles_id`, `roles_name`) VALUES
(1, 'Admin'),
(2, 'Employee');

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route` (
  `route_id` int(11) NOT NULL,
  `route_vehicle_id` varchar(255) NOT NULL,
  `route_from_city` varchar(255) NOT NULL,
  `route_from_arrival` varchar(255) NOT NULL,
  `route_from_departure` varchar(255) NOT NULL,
  `route_to_city` varchar(255) NOT NULL,
  `route_economy_fare` varchar(255) NOT NULL,
  `route_business_fare` varchar(255) NOT NULL,
  `route_duration` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`route_id`, `route_vehicle_id`, `route_from_city`, `route_from_arrival`, `route_from_departure`, `route_to_city`, `route_economy_fare`, `route_business_fare`, `route_duration`) VALUES
(2, '1', '2', '12:00', '09:00', '12', '100', '150', '2h 35m'),
(3, '2', '2', '01:00 ', '03:45', '16', '200', '300', '1h 50m'),
(4, '3', '2', '03:20', '06:32', '16', '1500', '1700', '10h 15m'),
(5, '4', '11', '04:55', '06:45', '16', '600', '800', '4h 12m'),
(6, '5', '2', '12:10', '06:55', '10', '200', '300', '6h 10m'),
(7, '5', '10', '13:20 ', '13:40	', '11', '300', '400', '3h 10m'),
(8, '5', '11', '16:35', '16:45', '13', '400', '400', '1h 30m');

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `salary_id` int(11) NOT NULL,
  `salary_employee_id` varchar(255) NOT NULL,
  `salary_month` varchar(255) NOT NULL,
  `salary_working_days` varchar(255) NOT NULL,
  `salary_basic` varchar(255) NOT NULL,
  `salary_hra` varchar(255) NOT NULL,
  `salary_mediclaim` varchar(255) NOT NULL,
  `salary_ta` varchar(255) NOT NULL,
  `salary_da` varchar(255) NOT NULL,
  `salary_reimbursement` varchar(255) NOT NULL,
  `salary_ca` varchar(255) NOT NULL,
  `salary_others` varchar(255) NOT NULL,
  `salary_dpf` varchar(255) NOT NULL,
  `salary_dtax` varchar(255) NOT NULL,
  `salary_desc` text NOT NULL,
  `salary_total` varchar(255) NOT NULL,
  `salary_dedc` varchar(255) NOT NULL,
  `salary_slip` longblob,
  `salary_slip_filename` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`salary_id`, `salary_employee_id`, `salary_month`, `salary_working_days`, `salary_basic`, `salary_hra`, `salary_mediclaim`, `salary_ta`, `salary_da`, `salary_reimbursement`, `salary_ca`, `salary_others`, `salary_dpf`, `salary_dtax`, `salary_desc`, `salary_total`, `salary_dedc`, `salary_slip`, `salary_slip_filename`) VALUES
(91, '1003', '8', '30', '1000', '1000', '1000', '1', '1', '1', '1', '1', '1', '1', '1', '4000', '1', NULL, '1630263488_303881675-Vehicle-Showroom-Management-System-Project-Report-in-PHP-and-MySQL (1).docx'),
(92, '1002', '5', '30', '3500', '4500', '3', '3', '3', '3', '3', '3', '3', '3', '3', '7500', '3', NULL, '1630263915_0584082100172_.pdf');

-- --------------------------------------------------------

--
-- Table structure for table `saluation`
--

CREATE TABLE `saluation` (
  `saluation_id` int(11) NOT NULL,
  `saluation_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saluation`
--

INSERT INTO `saluation` (`saluation_id`, `saluation_name`) VALUES
(1, 'Mr.'),
(2, 'Mrs.');

-- --------------------------------------------------------

--
-- Table structure for table `sell`
--

CREATE TABLE `sell` (
  `sell_id` int(11) NOT NULL,
  `sell_order_id` varchar(255) NOT NULL,
  `sell_vehicle_id` varchar(255) NOT NULL,
  `sell_units` varchar(255) NOT NULL,
  `sell_price_per_unit` varchar(255) NOT NULL,
  `sell_total_cost` varchar(255) NOT NULL,
  `sell_product_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sell`
--

INSERT INTO `sell` (`sell_id`, `sell_order_id`, `sell_vehicle_id`, `sell_units`, `sell_price_per_unit`, `sell_total_cost`, `sell_product_id`) VALUES
(89, '88', '5', '1', '1', '1', NULL),
(90, '88', '9', '4', '10', '40', NULL),
(91, '88', '7', '4', '10', '40', NULL),
(92, '88', '10', '5', '100', '500', NULL),
(95, '93', '8', '5', '100', '500', NULL),
(96, '93', '9', '4', '10', '40', NULL),
(97, '93', '10', '4', '100', '400', NULL),
(99, '98', '5', '34', '1', '34', NULL),
(102, '100', '8', '3', '100', '300', NULL),
(103, '100', '10', '4', '100', '400', NULL),
(104, '100', '9', '2', '10', '20', NULL),
(105, '100', '6', '4', '10', '40', NULL),
(172, '0', '5', '1', '80', '80', NULL),
(173, '0', '5', '1', '80', '80', NULL),
(174, '0', '5', '1', '80', '80', NULL),
(175, '0', '5', '1', '80', '80', NULL),
(178, '0', '5', '1', '80', '80', NULL),
(179, '0', '5', '1', '80', '80', NULL),
(181, '180', '5', '1', '80', '80', NULL),
(183, '182', '5', '1', '80', '80', NULL),
(184, '182', '5', '1', '80', '80', NULL),
(185, '182', '5', '1', '80', '80', NULL),
(186, '182', '5', '1', '80', '80', NULL),
(187, '182', '5', '1', '80', '80', NULL),
(188, '182', '5', '1', '80', '80', NULL),
(189, '182', '7', '1', '120', '120', NULL),
(190, '182', '7', '1', '120', '120', NULL),
(191, '182', '7', '1', '120', '120', NULL),
(193, '192', '5', '1', '80', '80', NULL),
(194, '192', '11', '1', '300', '300', NULL),
(195, '192', '9', '1', '30', '30', NULL),
(202, '196', '5', '1', '80', '80', NULL),
(207, '196', '1', '1', '100', '100', NULL),
(209, '208', '5', '1', '80', '80', NULL),
(213, '208', '1', '1', '100', '100', NULL),
(218, '208', '12', '1', '400', '400', NULL),
(220, '219', '5', '1', '80', '80', NULL),
(222, '219', '11', '1', '300', '300', NULL),
(223, '219', '7', '1', '120', '120', NULL),
(233, '232', '7', '1', '120', '120', NULL),
(234, '232', '12', '1', '400', '400', NULL),
(236, '232', '5', '1', '80', '80', NULL),
(238, '232', '1', '1', '100', '100', NULL),
(240, '232', '7', '1', '120', '120', NULL),
(243, '242', '7', '1', '120', '120', NULL),
(246, '245', '5', '1', '80', '80', NULL),
(247, '245', '7', '1', '120', '120', NULL),
(248, '245', '9', '1', '30', '30', NULL),
(251, '250', '5', '1', '80', '80', NULL),
(252, '250', '7', '1', '120', '120', NULL),
(254, '253', '10', '1', '80', '80', NULL),
(255, '253', '1', '1', '100', '100', NULL),
(257, '256', '12', '1', '400', '400', NULL),
(258, '256', '5', '1', '80', '80', NULL),
(260, '256', '9', '1', '30', '30', NULL),
(262, '261', '5', '1', '80', '80', NULL),
(264, '263', '9', '1', '30', '30', NULL),
(265, '263', '10', '1', '80', '80', NULL),
(273, '271', '10', '1', '80', '80', NULL),
(274, '271', '9', '1', '30', '30', NULL),
(277, '275', '9', '1', '30', '30', NULL),
(278, '275', '1', '1', '100', '100', NULL),
(291, '290', '9', '1', '30', '30', NULL),
(293, '292', '5', '1', '800', '800', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

CREATE TABLE `state` (
  `state_id` int(11) NOT NULL,
  `state_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`state_id`, `state_name`) VALUES
(1, 'Maharastra'),
(2, 'Gujrat'),
(3, 'Bihar'),
(4, 'Uttar Pradesh'),
(5, 'Delhi'),
(6, 'Haryana');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `vehicle_id` int(11) NOT NULL,
  `vehicle_company_id` varchar(255) NOT NULL,
  `vehicle_category_id` varchar(255) NOT NULL,
  `vehicle_name` varchar(255) NOT NULL,
  `vehicle_no` varchar(255) NOT NULL,
  `vehicle_from` varchar(255) NOT NULL,
  `vehicle_deaprture` varchar(255) NOT NULL,
  `vehicle_to` varchar(255) NOT NULL,
  `vehicle_arrival` varchar(255) NOT NULL,
  `vehicle_travel_time` varchar(255) NOT NULL,
  `vehicle_total_distance` varchar(255) NOT NULL,
  `vehicle_image_filename` varchar(255) NOT NULL,
  `vehicle_image` longblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`vehicle_id`, `vehicle_company_id`, `vehicle_category_id`, `vehicle_name`, `vehicle_no`, `vehicle_from`, `vehicle_deaprture`, `vehicle_to`, `vehicle_arrival`, `vehicle_travel_time`, `vehicle_total_distance`, `vehicle_image_filename`, `vehicle_image`) VALUES
(2, '1', '1', 'India Air', 'AI-1563', '2', '12:20 AM', '16', '09:12 PM', '12 Hours', '1200 KM', 'india.jpeg', ''),
(3, '2', '2', 'Oman Airs', 'OA-9078', '2', '09:30 AM', '16', '10:45 PM', '07 Hours', '1200', 'oman.jpeg', ''),
(4, '3', '1', 'France A098', 'FR-22104', '5', '07:40 AM', '1', '08:12 PM', '09 Hours', '', 'france.jpeg', ''),
(5, '4', '2', 'Canadian CDE', 'AC-12324', '2', '06:55 AM', '17', '03:00 AM', '26 Hours', '1462', 'airlines.jpeg', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`city_id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`company_id`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`contact_id`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`country_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`department_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feedback_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`login_id`);

--
-- Indexes for table `month`
--
ALTER TABLE `month`
  ADD PRIMARY KEY (`month_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `passengar`
--
ALTER TABLE `passengar`
  ADD PRIMARY KEY (`passengar_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`roles_id`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`route_id`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`salary_id`);

--
-- Indexes for table `saluation`
--
ALTER TABLE `saluation`
  ADD PRIMARY KEY (`saluation_id`);

--
-- Indexes for table `sell`
--
ALTER TABLE `sell`
  ADD PRIMARY KEY (`sell_id`);

--
-- Indexes for table `state`
--
ALTER TABLE `state`
  ADD PRIMARY KEY (`state_id`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`vehicle_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `city_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `company_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `contact_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=148;

--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `country_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `department_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1015;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `feedback_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=149;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `login_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;

--
-- AUTO_INCREMENT for table `month`
--
ALTER TABLE `month`
  MODIFY `month_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=376;

--
-- AUTO_INCREMENT for table `passengar`
--
ALTER TABLE `passengar`
  MODIFY `passengar_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=377;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=168;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `roles_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `route`
--
ALTER TABLE `route`
  MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=300;

--
-- AUTO_INCREMENT for table `salary`
--
ALTER TABLE `salary`
  MODIFY `salary_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT for table `saluation`
--
ALTER TABLE `saluation`
  MODIFY `saluation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sell`
--
ALTER TABLE `sell`
  MODIFY `sell_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=294;

--
-- AUTO_INCREMENT for table `state`
--
ALTER TABLE `state`
  MODIFY `state_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `vehicle_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
