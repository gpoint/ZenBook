--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `title` char(60) NOT NULL,
  `star_actors` tinytext NOT NULL,
  `director` char(100) NOT NULL,
  `genre` char(100) NOT NULL,
  `age_classification` char(100) NOT NULL,
  `showing` char(100) NOT NULL,
  `showing_time` tinytext NOT NULL,
  `screen` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` VALUES('Aquaman', 'Jason Statham, 50 Cents', 'Hansel Dan', 'Action', '>13|PG', '1', '109090932', 3);
