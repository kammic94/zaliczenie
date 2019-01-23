1. Przygotuj 4 maszyny
2. Uzupełnij hosts.ini publicznymi adresami IP
 
3. Wejdz na freenom.com i zaloguj się dowolną metodą
4. Utwórz dwie domeny, jedna na aplikacje, druga na domene.
5. Wejdz w "my domains" > manage > manage dns > pierwsza opcja > rekord A ma wskazywać na publiczne ip z nginx-proxy_nodes

6. Otwórz roles/config-nginx/template/nginx.conf 
7. W "upstream my app", zamień dwa adresy IP na prywatne z app_nodes, na porcie 8080.
8. Zamień adresy domen na swoje
9. Proxy pass na samym dole na wskazywać na publiczny adres IP z stats_nodes, na porcie 8080.

10. Wejdz do roles/config-ssl/tasks/main.yml 
11. Zmień nazwy domen i wpisz swój adres e-mail.

12. Wejdz do roles/install-telegraf/defaults
13. Zmień zmienną  telegraf_influx_url, tak aby wskazywała na publiczny adres z stats_nodes, na porcie 8086

14. Wpisz do konsoli:
    eval `ssh-agent`
    ssh-add id.student
    student1
    ansible-playbook -i hosts.ini infrastructure.yml
15. \o/
