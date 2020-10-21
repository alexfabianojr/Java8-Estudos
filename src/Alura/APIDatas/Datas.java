package Alura.APIDatas;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();

        System.out.println(hoje);

        LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);

        //forma errada
        int anos = olimpiadasRio.getYear() - hoje.getYear();

        System.out.println(anos);

        //forma correta
        Period periodo = Period.between(hoje, olimpiadasRio);

        System.out.println(periodo);
        System.out.println(periodo.isZero());
        System.out.println(periodo.getMonths());
        System.out.println(periodo.isNegative());

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(olimpiadasRio.format(formatador));

        LocalDateTime agora = LocalDateTime.now();

        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

        System.out.println(agora.format(formatadorComHoras));

        agora.toLocalDate();

        Year ano = Year.now();

        System.out.println(ano);

        YearMonth anoMes = YearMonth.now();

        System.out.println(anoMes);

        Month mes = Month.DECEMBER;

        System.out.println(mes);

        LocalTime horaMinuto = LocalTime.now();

        System.out.println(horaMinuto);

        ZonedDateTime timeZone = ZonedDateTime.now();

        System.out.println(timeZone);

    }
}
