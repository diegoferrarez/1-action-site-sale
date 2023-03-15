package com.br.actionsitesale.service.impl;

import com.br.actionsitesale.controller.dto.request.ReservationRequest;
import com.br.actionsitesale.controller.dto.response.ReservationResponse;
import com.br.actionsitesale.controller.dto.response.credential.TokenResponse;
import com.br.actionsitesale.model.Credential;
import com.br.actionsitesale.model.Reservation;
import com.br.actionsitesale.model.enums.StatusReservation;
import com.br.actionsitesale.repository.ReservationControlRepository;
import com.br.actionsitesale.service.AcessControlService;
import com.br.actionsitesale.service.feign.api.UserApi;
import com.br.actionsitesale.service.mapper.RegisterProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class AcessControlServiceImpl implements AcessControlService {

    private final RegisterProductMapper mapper;

    private final ExtranetApi extranetApi;
    private final UserApi userApi;

    private final ModelMapper modelMapper;
    @Autowired
    private ReservationControlRepository repository;
    @Autowired
    private final EnviaEmailService enviaEmailService;

    @Override
    @Transactional
    public List<ReservationResponse> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<Reservation> reservations = repository.findAll();
        return Arrays.asList(modelMapper.map(reservations, ReservationResponse[].class));
    }

    @Override
    @Transactional
    public ReservationResponse findByHeader(Credential credential, Long id){
        TokenResponse tokenResponse = userApi.getByName(
                credential.getUnit(),
                credential.getSerialNumberUnit());
        if(validarToken()){

        }
    }

    @Override
    @Transactional
    public ReservationResponse createReservation(String userLogin, String password, ReservationRequest dto) {
        var reservation = saveReservation(dto);
        reservation.setStatus(StatusReservation.ACTIVE);
        var reservationPersist = this.repository.save(reservation);
        return this.mapper.toAcessResponse(reservationPersist);
    }

    @Override
    @Transactional
    public ReservationResponse cancelReservation(String userLogin, String password, String numberReservation){
        var reservation = repository.findBy(numberReservation);
        reservation.setStatus(StatusReservation.CANCELED);
        final Reservation reservationUpdate = repository.save(reservation);
        return this.mapper.toAcessResponse(reservationUpdate);
    }

    @Override
    public List<ReservationResponse> download() {
        ModelMapper modelMapper = new ModelMapper();
        List<Reservation> reservations = repository.findAll();
        String fileName = "C:/novo.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Reservas");

        int rownum = 0;

        for (Reservation reservation : reservations){
            Row row = sheet.createRow(rownum++);
            int cellnum = 0;

            Cell cellOp = row.createCell(cellnum++);
            cellOp.setCellValue(reservation.getId());
        }
        try {
            FileOutputStream out
                    = new FileOutputStream(new File(fileName));
            workbook.write(out);
            out.close();
            System.out.println("Arquivo Excel criado com sucesso!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro na edição do arquivo!");
        }

        return null;
//        //Criando o arquivo
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet(reservations.toString());
//
//        //Definindo padrão de layout
//        sheet.setDefaultColumnWidth(15);
//        sheet.setDefaultRowHeight((short) 400);
//
//        //carregando produtos
//        List<Reservation> reservationList = repository.findAll();
//        int rownum = 0;
//        int cellnum = 0;
//        Cell cell;
//        Row row;
//
//        // Configurando Header
//        row = sheet.createRow(rownum++);
//        cell = row.createCell(cellnum++);
//        cell.setCellValue("numberReservation");
//
//        cell = row.createCell(cellnum++);
//        cell.setCellValue("numberReservationRoom");
//
//        cell = row.createCell(cellnum++);
//        cell.setCellValue("nameReservationClient");
//
//        cell = row.createCell(cellnum++);
//        cell.setCellValue("valuePerDayRoom");
//
//        cell = row.createCell(cellnum++);
//        cell.setCellValue("phoneNumber");
//
//        cell = row.createCell(cellnum++);
//        cell.setCellValue("documentNumber");
//
//        cell = row.createCell(cellnum++);
//        cell.setCellValue("documentType");
//
//        cell = row.createCell(cellnum++);
//        cell.setCellValue("status");
//
//        // Adicionando os dados dos produtos na planilha
//        for (Reservation reservation : reservations) {
//            row = sheet.createRow(rownum++);
//            cellnum = 0;
//
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(reservation.getId());
//
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(reservationList.getNumberReservation());
//
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(reservation.getNameReservationClient());
//
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(String.valueOf(reservation.getValuePerDayRoom()));
//
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(reservation.getPhoneNumber());
//
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(reservation.getDocumentNumber());
//
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(String.valueOf(reservation.getDocumentType()));
//
//            cell = row.createCell(cellnum++);
//            cell.setCellValue(String.valueOf(reservation.getStatus()));
//        }
//
//            try {
//                //Escrevendo o arquivo em disco
//                FileOutputStream out = new FileOutputStream(new File("/tmp/reservation.xls"));
//                workbook.write(out);
//                out.close();
//                workbook.close();
//                System.out.println("Success!!");
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//    //simulando uma listagem
//        ModelMapper modelMapper = new ModelMapper();
//        List<Reservation> reservations = repository.findAll();
//        XSSFWorkbook wb = new XSSFWorkbook();
//        String PathTillProject = System.getProperty("C:\Users\Alex Sacramento\Desktop\Github - Diego\action-site-sale");
//
//
//        //criar uma planilha
//        XSSFWorkbook wb = new XSSFWorkbook();
//
//    //pegar o diretório do usuário e criar um arquivo com o determinado nome
//        String PathTillProject = System.getProperty("user.dir");
//        FileOutputStream fileOut = new FileOutputStream(PathTillProject + "/src/Export.xls");
//
//    //criar várias abas
//        XSSFSheet abaPrimaria = wb.createSheet("ABA 1");
//        XSSFSheet abaSecundaria = wb.createSheet("ABA 2");
//
//    //criar linhas (passar o nome da aba onde deseja criar)
//        XSSFRow primeiraLinha = abaPrimaria.createRow(0);
//        XSSFRow segundaLinha = abaPrimaria.createRow(0);
//
//    //criar uma célula em uma linha (passar o nome da linha onde deseja criar)
//        XSSFCell primeiraCelulaColuna = primeiraLinha.createCell(0);
//        XSSFCell segundaCelulaColuna = primeiraLinha.createCell(1);
//
//    //escrever tudo o que foi feito no arquivo
//        wb.write(fileOut);
//
//    //fecha a escrita de dados nessa planilha
//        wb.close();
//
////        Workbook workbook = new XSSFWorkbook();
////        Sheet sheet = workbook.createSheet("Dados");
////        int rownum = 0;
////        for (Document document : collection.find()) {
////            Row row = sheet.createRow(rownum++);
////            int cellnum = 0;
////            for (String key : document.keySet()) {
////                Cell cell = row.createCell(cellnum++);
////                cell.setCellValue(document.get(key).toString());
////            }
////        }
////        FileOutputStream out = new FileOutputStream(new File("dados.xlsx"));
////        workbook.write(out);
////        out.close();
////        return null;
////        Runtime r = Runtime.getRuntime();
////        Process p =  null;
////        String command = "mongoimport --db test --collection AcessControlRooms --type csv --file /opt/backups/AcessControlRooms.csv";
////        try {
////            p = r.exec(command);
////            System.out.println("Reading csv into Database");
////
////        } catch (Exception e){
////            System.out.println("Error executing " + command + e.toString());
////        }
////        return ("OK");
        }


    private boolean validarToken() {
        return Boolean.TRUE;
    }

    private Reservation saveReservation(ReservationRequest a){
        return Reservation.builder()
                .numberReservation(a.getNumberReservation())
                .numberReservationRoom(a.getNumberReservationRoom())
                .valuePerDayRoom(a.getValuePerDayRoom())
                .nameReservationClient(a.getNameReservationClient())
                .documentNumber(a.getDocumentNumber())
                .documentType(a.getDocumentType())
                .phoneNumber(a.getPhoneNumber())
                .status(a.getStatus())
                .build();
    }


    public AcessControlServiceImpl(RegisterProductMapper mapper, UserApi userApi, ModelMapper modelMapper, EnviaEmailService enviaEmailService) {
        this.mapper = mapper;
        this.userApi = userApi;
        this.modelMapper = modelMapper;
        this.enviaEmailService = enviaEmailService;
    }
}
