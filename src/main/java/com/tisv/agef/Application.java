package com.tisv.agef;

import com.tisv.agef.domains.Defeito;
import com.tisv.agef.domains.Modelo;
import com.tisv.agef.domains.PecaFeira;
import com.tisv.agef.domains.Venda;
import com.tisv.agef.services.DefeitoService;
import com.tisv.agef.services.ModeloService;
import com.tisv.agef.services.PecaFeiraService;
import com.tisv.agef.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final ModeloService modeloService;

    private final PecaFeiraService pecaFeiraService;

    private final DefeitoService defeitoService;

    private final VendaService vendaService;

    @Autowired
    public Application(ModeloService modeloService, PecaFeiraService pecaFeiraService, DefeitoService defeitoService, VendaService vendaService) {
        this.modeloService = modeloService;
        this.pecaFeiraService = pecaFeiraService;
        this.defeitoService = defeitoService;
        this.vendaService = vendaService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        Modelo m1 = new Modelo("Calça", "36");
        Modelo m2 = new Modelo("Calça", "37");
        Modelo m3 = new Modelo("Calça", "38");
        Modelo m4 = new Modelo("Camisa", "P");
        Modelo m5 = new Modelo("Camisa", "M");
        Modelo m6 = new Modelo("Camisa", "G");
        Modelo m7 = new Modelo("Moletom", "P");
        Modelo m8 = new Modelo("Moletom", "M");
        Modelo m9 = new Modelo("Moletom", "G");

        List<Modelo> modelos = new ArrayList<>(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9));
        modelos.forEach(modeloService::insert);

        PecaFeira p1 = new PecaFeira(30.50, 20, m1);
        PecaFeira p2 = new PecaFeira(39.99, 20, m2);
        PecaFeira p3 = new PecaFeira(50.00, 20, m3);
        PecaFeira p4 = new PecaFeira(120.00, 20, m4);
        PecaFeira p5 = new PecaFeira(85.00, 20, m5);
        PecaFeira p6 = new PecaFeira(69.99, 20, m6);
        PecaFeira p7 = new PecaFeira(45.00, 20, m7);
        PecaFeira p8 = new PecaFeira(20.00, 20, m8);
        PecaFeira p9 = new PecaFeira(149.99, 20, m9);

        List<PecaFeira> pecas = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
        pecas.forEach(pecaFeiraService::insert);

        Venda v1 = new Venda(30.50, 2, p1, LocalDate.of(2018, 10, 7));
        Venda v1A = new Venda(149.99, 3, p9, LocalDate.of(2018, 10, 7));
        Venda v1B = new Venda(45.00, 1, p7, LocalDate.of(2018, 10, 7));

        Venda v2 = new Venda(39.99, 4, p2, LocalDate.of(2018, 10, 14));
        Venda v2A = new Venda(20.00, 1, p8, LocalDate.of(2018, 10, 14));
        Venda v2B = new Venda(69.99, 3, p6, LocalDate.of(2018, 10, 14));

        Venda v3 = new Venda(50.00, 2, p3, LocalDate.of(2018, 10, 21));
        Venda v3A = new Venda(85.00, 1, p5, LocalDate.of(2018, 10, 21));
        Venda v3B = new Venda(39.99, 3, p2, LocalDate.of(2018, 10, 21));

        Venda v4 = new Venda(120.00, 1, p4, LocalDate.of(2018, 10, 28));
        Venda v4A = new Venda(30.50, 3, p1, LocalDate.of(2018, 10, 28));
        Venda v4B = new Venda(149.99, 2, p9, LocalDate.of(2018, 10, 28));

        Venda v5 = new Venda(85.00, 1, p5, LocalDate.of(2018, 11, 4));
        Venda v5A = new Venda(50.00, 2, p3, LocalDate.of(2018, 11, 4));
        Venda v5B = new Venda(120.00, 3, p4, LocalDate.of(2018, 11, 4));

        Venda v6 = new Venda(30.50, 1, p1, LocalDate.now());
        Venda v6A = new Venda(39.99, 1, p2, LocalDate.now());
        Venda v6B = new Venda(50.00, 1, p3, LocalDate.now());
        Venda v6C = new Venda(120.00, 1, p4, LocalDate.now());
        Venda v6D = new Venda(85.00, 1, p5, LocalDate.now());
        Venda v6E = new Venda(69.99, 1, p6, LocalDate.now());
        Venda v6F = new Venda(45.00, 1, p7, LocalDate.now());
        Venda v6G = new Venda(20.00, 1, p8, LocalDate.now());
        Venda v6H = new Venda(149.99, 1, p9, LocalDate.now());


        List<Venda> vendas = new ArrayList<>(Arrays.asList(
                v1, v1A, v1B, v2, v2A, v2B, v3, v3A, v3B, v4, v4A, v4B, v5, v5A, v5B, v6, v6A, v6B, v6C, v6D, v6E, v6F, v6G, v6H
        ));
        vendas.forEach(vendaService::insert);

        Defeito d1 = new Defeito(p1, 1, LocalDate.now());
        Defeito d2 = new Defeito(p2, 1, LocalDate.now());
        Defeito d3 = new Defeito(p3, 1, LocalDate.now());
        Defeito d4 = new Defeito(p4, 1, LocalDate.now());
        Defeito d5 = new Defeito(p5, 1, LocalDate.now());
        Defeito d6 = new Defeito(p6, 1, LocalDate.now());
        Defeito d7 = new Defeito(p7, 1, LocalDate.now());
        Defeito d8 = new Defeito(p8, 1, LocalDate.now());
        Defeito d9 = new Defeito(p9, 1, LocalDate.now());

        List<Defeito> defeitos = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
        defeitos.forEach(defeitoService::insert);
    }
}
