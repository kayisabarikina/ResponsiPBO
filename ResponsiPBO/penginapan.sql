-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Jun 2023 pada 13.44
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penginapan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `accounts`
--

CREATE TABLE `accounts` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(10) NOT NULL DEFAULT 'renter'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `accounts`
--

INSERT INTO `accounts` (`username`, `password`, `role`) VALUES
('admin', 'admin', 'admin'),
('user1', 'user1', 'renter');

-- --------------------------------------------------------

--
-- Struktur dari tabel `renter`
--

CREATE TABLE `renter` (
  `name` varchar(50) NOT NULL,
  `id` varchar(30) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `duration` int(11) NOT NULL,
  `bill` int(11) DEFAULT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'notPaid',
  `room` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `renter`
--

INSERT INTO `renter` (`name`, `id`, `contact`, `duration`, `bill`, `status`, `room`) VALUES
('Juan Azhar', '123200139', 'juanjay@pboh.com', 2, 200000, 'notPaid', 'A1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rooms`
--

CREATE TABLE `rooms` (
  `name` varchar(5) NOT NULL,
  `size` varchar(5) NOT NULL,
  `price` int(11) NOT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'empty'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `rooms`
--

INSERT INTO `rooms` (`name`, `size`, `price`, `status`) VALUES
('A1', '3x4', 200000, 'empty'),
('A2', '3x4', 200000, 'Post Malone'),
('B1', '4x4', 230000, 'empty'),
('B2', '4x4', 250000, 'empty'),
('C1', '5x5', 450000, 'empty'),
('C2', '5x4', 400000, 'empty');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `accounts`
--
ALTER TABLE `accounts`
  ADD UNIQUE KEY `username` (`username`);

--
-- Indeks untuk tabel `renter`
--
ALTER TABLE `renter`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indeks untuk tabel `rooms`
--
ALTER TABLE `rooms`
  ADD UNIQUE KEY `name` (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
