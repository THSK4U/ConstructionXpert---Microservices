CREATE TABLE taches (
                        id SERIAL PRIMARY KEY,
                        description VARCHAR(255),
                        date_Debut DATE,
                        date_Fin DATE,
                        statut ENUM('A_FAIRE', 'EN_COURS', 'TERMINE'),
                        projet_Id INT
);
