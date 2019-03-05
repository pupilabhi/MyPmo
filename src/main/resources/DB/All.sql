/*Status List*/
/*PROJECT STATUS*/
INSERT INTO vikray_pmo.status_item (id, description, status_constant, status_type) VALUES(1, 'New Project', 'PROJECT_NEW', 'PROJECT');
INSERT INTO vikray_pmo.status_item (id, description, status_constant, status_type)VALUES(2, 'In Progress', 'PROEJCT_IN_PROGRESS', 'PROJECT');
INSERT INTO vikray_pmo.status_item (id, description, status_constant, status_type)VALUES(3, 'Completed', 'PROJECT_COMPLETE', 'PROJECT');

/* PHASE STATUS */
INSERT INTO vikray_pmo.status_item (id, description, status_constant, status_type)VALUES(4, 'New Phase', 'PHASE_New', 'PHASE');
INSERT INTO vikray_pmo.status_item (id, description, status_constant, status_type)VALUES(5, 'In Progress', 'PHASE_IN_PROGRESS', 'PHASE');
INSERT INTO vikray_pmo.status_item (id, description, status_constant, status_type)VALUES(6, 'Completed', 'PHASE_COMPLETE', 'PHASE');