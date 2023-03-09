package com.br.actionsitesale.service.impl;

import com.br.actionsitesale.model.Reservation;
import com.br.actionsitesale.repository.ReservationControlRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
public class CriaArquivoExcel {

    @Autowired
    private ReservationControlRepository repository;

    public CriaArquivoExcel() {
    }

    public void criarArquivo(final String nomeArquivo, final List<Reservation> reservation){
        log.info("Gerando Arquivo{}", nomeArquivo);
        try (var workbook = new XSSFWorkbook();
             var outputStream = new FileOutputStream(nomeArquivo)) {
            var planilha = workbook.createSheet("Lista de Clientes");
            int numeroDaLinha = 0;
            adicionarCabecalho(planilha, numeroDaLinha++);

            for (Reservation reservations : reservation) {
                var linha = planilha.createRow(numeroDaLinha++);
                adicionarCelula(linha, 0, reservations.getId());
                adicionarCelula(linha, 1, reservations.getNumberReservation());
                adicionarCelula(linha, 2, reservations.getNumberReservationRoom());
                adicionarCelula(linha, 3, reservations.getNameReservationClient());
                adicionarCelula(linha, 4, reservations.getDocumentNumber());
                adicionarCelula(linha, 5, String.valueOf(reservations.getDocumentType()));
                adicionarCelula(linha, 6, reservations.getPhoneNumber());
                adicionarCelula(linha, 7, String.valueOf(reservations.getStatus()));
                adicionarCelula(linha, 8, String.valueOf(reservations.getValuePerDayRoom()));
            }

            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            log.error("Arquivo não encontrado: {}", nomeArquivo);
        } catch (IOException e) {
            log.error("Erro ao processar o arquivo: {} ", nomeArquivo);
        }
        log.info("Arquivo gerado com sucesso!");
    }

    public void criarArquivoMongo(final String nomeArquivo, final List<Reservation> reservation){
        log.info("Gerando Arquivo{}", nomeArquivo);
        try (var workbook = new XSSFWorkbook();
             var outputStream = new FileOutputStream(nomeArquivo)) {
            var planilha = workbook.createSheet("Lista de Clientes");
            int numeroDaLinha = 0;
            adicionarCabecalho(planilha, numeroDaLinha++);

            for (Reservation reservations : reservation) {
                var linha = planilha.createRow(numeroDaLinha++);
                adicionarCelula(linha, 0, String.valueOf(repository.findById(reservations.getId())));
                adicionarCelula(linha, 1, reservations.getNumberReservation());
                adicionarCelula(linha, 2, reservations.getNumberReservationRoom());
                adicionarCelula(linha, 3, reservations.getNameReservationClient());
                adicionarCelula(linha, 4, reservations.getDocumentNumber());
                adicionarCelula(linha, 5, String.valueOf(reservations.getDocumentType()));
                adicionarCelula(linha, 6, reservations.getPhoneNumber());
                adicionarCelula(linha, 7, String.valueOf(reservations.getStatus()));
                adicionarCelula(linha, 8, String.valueOf(reservations.getValuePerDayRoom()));
            }

            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            log.error("Arquivo não encontrado: {}", nomeArquivo);
        } catch (IOException e) {
            log.error("Erro ao processar o arquivo: {} ", nomeArquivo);
        }
        log.info("Arquivo gerado com sucesso!");
    }

    private void adicionarCabecalho(XSSFSheet planilha, int numeroLinha) {
        var linha = planilha.createRow(numeroLinha);
        adicionarCelula(linha, 0, "Id");
        adicionarCelula(linha, 1, "NumberReservation");
        adicionarCelula(linha, 2, "NumberReservationRoom");
        adicionarCelula(linha, 3, "NameReservationClient");
        adicionarCelula(linha, 4, "DocumentNumber");
        adicionarCelula(linha, 5, "DocumentType");
        adicionarCelula(linha, 6, "PhoneNumber");
        adicionarCelula(linha, 7, "Status");
        adicionarCelula(linha, 8, "ValuePerDayRoom");
    }

    private void adicionarCelula(Row linha, int coluna, String valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }

    private void adicionarCelula(Row linha, int coluna, int valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }
}
