package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }
    @Test
    public void whenAddPassportDublicate() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen duplicateCitizen = new Citizen("2f44a", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        boolean firstAdd = office.add(citizen);
        assertThat(firstAdd).isTrue();
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
        boolean secondAdd = office.add(duplicateCitizen);
        assertThat(secondAdd).isFalse();
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }
}