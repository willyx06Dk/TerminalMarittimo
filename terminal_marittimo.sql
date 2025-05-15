-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 15, 2025 alle 22:38
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `terminal_marittimo`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `autista`
--

CREATE TABLE `autista` (
  `ID` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `cognome` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `autista`
--

INSERT INTO `autista` (`ID`, `nome`, `cognome`, `email`) VALUES
(1, 'gianpiero', 'rossi', 'sdzjdyxzkcxzjtz');

-- --------------------------------------------------------

--
-- Struttura della tabella `buono`
--

CREATE TABLE `buono` (
  `ID` int(11) NOT NULL,
  `quantita_merce` int(11) NOT NULL,
  `data_rilascio` date NOT NULL DEFAULT current_timestamp(),
  `id_emittente` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_merce` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `buono`
--

INSERT INTO `buono` (`ID`, `quantita_merce`, `data_rilascio`, `id_emittente`, `id_cliente`, `id_merce`) VALUES
(2, 10, '2025-05-15', 3, 2, 1),
(3, 10, '2025-05-15', 3, 2, 1),
(4, 10, '2025-05-15', 3, 2, 1),
(5, 10, '2025-05-15', 3, 2, 1),
(6, 10, '2025-05-15', 3, 2, 1),
(7, 10, '2025-05-15', 3, 2, 1),
(8, 10, '2025-05-15', 3, 2, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `camion`
--

CREATE TABLE `camion` (
  `targa` varchar(7) NOT NULL,
  `modello` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `camion`
--

INSERT INTO `camion` (`targa`, `modello`) VALUES
('AB123CD', 'Iveco Stralis');

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `ID` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `cognome` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `codice_identificativo_carta` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`ID`, `nome`, `cognome`, `username`, `password`, `email`, `codice_identificativo_carta`) VALUES
(2, 'pippo', 'rossi', 'PippoRed', '1a1dc91c907325c69271ddf0c944bc72', 'dgfhbfgnbcfnxfgnvdfnfndn', '4093761804862471120');

-- --------------------------------------------------------

--
-- Struttura della tabella `fornitore`
--

CREATE TABLE `fornitore` (
  `ID` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `fornitore`
--

INSERT INTO `fornitore` (`ID`, `nome`, `email`, `username`, `password`) VALUES
(4, 'cerealiEco', 'sdgjftukfgfykxtjkjd', 'cereali', '1a1dc91c907325c69271ddf0c944bc72');

-- --------------------------------------------------------

--
-- Struttura della tabella `magazzino`
--

CREATE TABLE `magazzino` (
  `ID` int(11) NOT NULL,
  `quantita_merce` int(11) NOT NULL,
  `id_merce` int(11) NOT NULL,
  `id_addetto` int(11) NOT NULL,
  `data_ultima_modifica` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `magazzino`
--

INSERT INTO `magazzino` (`ID`, `quantita_merce`, `id_merce`, `id_addetto`, `data_ultima_modifica`) VALUES
(2, 20, 1, 2, '2025-05-15');

-- --------------------------------------------------------

--
-- Struttura della tabella `merce`
--

CREATE TABLE `merce` (
  `ID` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `categoria` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `merce`
--

INSERT INTO `merce` (`ID`, `nome`, `categoria`) VALUES
(1, 'cereali', 'alimenti');

-- --------------------------------------------------------

--
-- Struttura della tabella `nave`
--

CREATE TABLE `nave` (
  `ID` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `nave`
--

INSERT INTO `nave` (`ID`, `nome`) VALUES
(1, 'xmnl5');

-- --------------------------------------------------------

--
-- Struttura della tabella `personale_terminale`
--

CREATE TABLE `personale_terminale` (
  `ID` int(11) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `ruolo` enum('Admin','Erogatore','Magazziniere') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `personale_terminale`
--

INSERT INTO `personale_terminale` (`ID`, `username`, `password`, `ruolo`) VALUES
(1, 'admin', '5f4dcc3b5aa765d61d8327deb882cf99', 'Admin'),
(2, 'primo', '1a1dc91c907325c69271ddf0c944bc72', 'Magazziniere'),
(3, 'secondo', '1a1dc91c907325c69271ddf0c944bc72', 'Erogatore'),
(4, 'terzo', '1a1dc91c907325c69271ddf0c944bc72', 'Magazziniere'),
(5, 'quarto', '1a1dc91c907325c69271ddf0c944bc72', 'Magazziniere'),
(6, 'quinto', '1a1dc91c907325c69271ddf0c944bc72', 'Erogatore'),
(7, 'Piero', '1a1dc91c907325c69271ddf0c944bc72', 'Magazziniere'),
(8, 'Marco', '1a1dc91c907325c69271ddf0c944bc72', 'Erogatore'),
(9, 'Franceso', '1a1dc91c907325c69271ddf0c944bc72', 'Magazziniere'),
(10, 'Pippo', '1a1dc91c907325c69271ddf0c944bc72', 'Erogatore');

-- --------------------------------------------------------

--
-- Struttura della tabella `polizza`
--

CREATE TABLE `polizza` (
  `ID` int(11) NOT NULL,
  `quantita_merce` int(11) NOT NULL,
  `id_viaggio` int(11) NOT NULL,
  `id_fornitore` int(11) NOT NULL,
  `id_merce` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `polizza`
--

INSERT INTO `polizza` (`ID`, `quantita_merce`, `id_viaggio`, `id_fornitore`, `id_merce`) VALUES
(4, 20, 9, 4, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `porto`
--

CREATE TABLE `porto` (
  `ID` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `nazionalita` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `porto`
--

INSERT INTO `porto` (`ID`, `nome`, `nazionalita`) VALUES
(2, 'Elba', 'italiana'),
(3, 'Roma', 'italiana');

-- --------------------------------------------------------

--
-- Struttura della tabella `registro`
--

CREATE TABLE `registro` (
  `ID` int(11) NOT NULL,
  `data_ritiro` date NOT NULL DEFAULT current_timestamp(),
  `peso_ritirato` int(11) NOT NULL,
  `id_autista` int(11) NOT NULL,
  `id_camion` varchar(7) NOT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `registro`
--

INSERT INTO `registro` (`ID`, `data_ritiro`, `peso_ritirato`, `id_autista`, `id_camion`, `id_cliente`) VALUES
(6, '2025-05-15', 10, 1, 'AB123CD', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `richiesta`
--

CREATE TABLE `richiesta` (
  `ID` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_merce` int(11) NOT NULL,
  `quantita_merce` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `viaggio`
--

CREATE TABLE `viaggio` (
  `ID` int(11) NOT NULL,
  `data_partenza` date NOT NULL,
  `data_arrivo` date NOT NULL,
  `porto_partenza` int(11) NOT NULL,
  `porto_arrivo` int(11) NOT NULL,
  `direttrice` varchar(64) NOT NULL,
  `id_addetto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `viaggio`
--

INSERT INTO `viaggio` (`ID`, `data_partenza`, `data_arrivo`, `porto_partenza`, `porto_arrivo`, `direttrice`, `id_addetto`) VALUES
(9, '2025-05-15', '2025-05-16', 2, 3, 'sud-ovest', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `viaggi_effettuati`
--

CREATE TABLE `viaggi_effettuati` (
  `ID` int(11) NOT NULL,
  `id_nave` int(11) NOT NULL,
  `id_viaggio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `viaggi_effettuati`
--

INSERT INTO `viaggi_effettuati` (`ID`, `id_nave`, `id_viaggio`) VALUES
(1, 1, 9);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `autista`
--
ALTER TABLE `autista`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `buono`
--
ALTER TABLE `buono`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_emittente` (`id_emittente`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_merce` (`id_merce`);

--
-- Indici per le tabelle `camion`
--
ALTER TABLE `camion`
  ADD PRIMARY KEY (`targa`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `fornitore`
--
ALTER TABLE `fornitore`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `magazzino`
--
ALTER TABLE `magazzino`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_merce` (`id_merce`),
  ADD KEY `id_addetto` (`id_addetto`);

--
-- Indici per le tabelle `merce`
--
ALTER TABLE `merce`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `nave`
--
ALTER TABLE `nave`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `personale_terminale`
--
ALTER TABLE `personale_terminale`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `polizza`
--
ALTER TABLE `polizza`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_viaggio` (`id_viaggio`),
  ADD KEY `id_fornitore` (`id_fornitore`),
  ADD KEY `id_merce` (`id_merce`);

--
-- Indici per le tabelle `porto`
--
ALTER TABLE `porto`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_autista` (`id_autista`),
  ADD KEY `id_camion` (`id_camion`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indici per le tabelle `richiesta`
--
ALTER TABLE `richiesta`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_merce` (`id_merce`);

--
-- Indici per le tabelle `viaggio`
--
ALTER TABLE `viaggio`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `porto_partenza` (`porto_partenza`),
  ADD KEY `porto_arrivo` (`porto_arrivo`),
  ADD KEY `id_addetto` (`id_addetto`);

--
-- Indici per le tabelle `viaggi_effettuati`
--
ALTER TABLE `viaggi_effettuati`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `id_nave` (`id_nave`),
  ADD KEY `id_viaggio` (`id_viaggio`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `autista`
--
ALTER TABLE `autista`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `buono`
--
ALTER TABLE `buono`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT per la tabella `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `fornitore`
--
ALTER TABLE `fornitore`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `magazzino`
--
ALTER TABLE `magazzino`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `merce`
--
ALTER TABLE `merce`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `nave`
--
ALTER TABLE `nave`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `personale_terminale`
--
ALTER TABLE `personale_terminale`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `polizza`
--
ALTER TABLE `polizza`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `porto`
--
ALTER TABLE `porto`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `registro`
--
ALTER TABLE `registro`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT per la tabella `richiesta`
--
ALTER TABLE `richiesta`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT per la tabella `viaggi_effettuati`
--
ALTER TABLE `viaggi_effettuati`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `buono`
--
ALTER TABLE `buono`
  ADD CONSTRAINT `buono_ibfk_1` FOREIGN KEY (`id_emittente`) REFERENCES `personale_terminale` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `buono_ibfk_2` FOREIGN KEY (`id_merce`) REFERENCES `merce` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `buono_ibfk_3` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limiti per la tabella `magazzino`
--
ALTER TABLE `magazzino`
  ADD CONSTRAINT `magazzino_ibfk_1` FOREIGN KEY (`id_merce`) REFERENCES `merce` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `magazzino_ibfk_2` FOREIGN KEY (`id_addetto`) REFERENCES `personale_terminale` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limiti per la tabella `polizza`
--
ALTER TABLE `polizza`
  ADD CONSTRAINT `polizza_ibfk_1` FOREIGN KEY (`id_viaggio`) REFERENCES `viaggio` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `polizza_ibfk_2` FOREIGN KEY (`id_fornitore`) REFERENCES `fornitore` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `polizza_ibfk_3` FOREIGN KEY (`id_merce`) REFERENCES `merce` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limiti per la tabella `registro`
--
ALTER TABLE `registro`
  ADD CONSTRAINT `registro_ibfk_1` FOREIGN KEY (`id_camion`) REFERENCES `camion` (`targa`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `registro_ibfk_2` FOREIGN KEY (`id_autista`) REFERENCES `autista` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limiti per la tabella `richiesta`
--
ALTER TABLE `richiesta`
  ADD CONSTRAINT `richiesta_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `richiesta_ibfk_2` FOREIGN KEY (`id_merce`) REFERENCES `merce` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limiti per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  ADD CONSTRAINT `viaggio_ibfk_1` FOREIGN KEY (`porto_partenza`) REFERENCES `porto` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `viaggio_ibfk_2` FOREIGN KEY (`porto_arrivo`) REFERENCES `porto` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `viaggio_ibfk_3` FOREIGN KEY (`id_addetto`) REFERENCES `personale_terminale` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limiti per la tabella `viaggi_effettuati`
--
ALTER TABLE `viaggi_effettuati`
  ADD CONSTRAINT `viaggi_effettuati_ibfk_1` FOREIGN KEY (`id_nave`) REFERENCES `nave` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `viaggi_effettuati_ibfk_2` FOREIGN KEY (`id_viaggio`) REFERENCES `viaggio` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
