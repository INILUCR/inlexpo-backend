INSERT INTO diccionario (nombre, descripcion, tipo) VALUES
('Diccionario 1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque metus tortor, porta quis viverra et, suscipit a arcu. Vivamus vel lacus diam. Nam vehicula nisl congue quam dapibus viverra. Phasellus sit amet aliquam mauris. Ut velit leo, interdum vitae fringilla in, sodales id turpis. Proin porttitor dolor nunc, ac mattis nisi fringilla a. Vivamus ac viverra est, vitae placerat orci. Etiam rutrum magna ut sapien maximus, at bibendum ante bibendum.', 'Tipo 1'),
('Diccionario 2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque metus tortor, porta quis viverra et, suscipit a arcu. Vivamus vel lacus diam. Nam vehicula nisl congue quam dapibus viverra. Phasellus sit amet aliquam mauris. Ut velit leo, interdum vitae fringilla in, sodales id turpis. Proin porttitor dolor nunc, ac mattis nisi fringilla a. Vivamus ac viverra est, vitae placerat orci. Etiam rutrum magna ut sapien maximus, at bibendum ante bibendum.', 'Tipo 2'),
('Diccionario 3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque metus tortor, porta quis viverra et, suscipit a arcu. Vivamus vel lacus diam. Nam vehicula nisl congue quam dapibus viverra. Phasellus sit amet aliquam mauris. Ut velit leo, interdum vitae fringilla in, sodales id turpis. Proin porttitor dolor nunc, ac mattis nisi fringilla a. Vivamus ac viverra est, vitae placerat orci. Etiam rutrum magna ut sapien maximus, at bibendum ante bibendum.', 'Tipo 3');

INSERT INTO categoria_gramatical (nombre, descripcion) VALUES
('Sustantivo','Son palabras cuyos referentes son clases de entidades fijas (a diferencia de los pronombres cuyos referentes son contextuales), no estados de hechos o relaciones gramaticales.'),
('Adjetivo','Es una parte de la oración o clase de palabra que complementa un sustantivo para calificarlo; expresa características o propiedades atribuidas a un sustantivo, ya sean concretas (perceptible por los sentidos, como en el libro grande o the big book) o abstractas (cognoscible por la mente, como en el libro difícil).'),
('Artículo','Es un tipo de determinante actualizador, una categoría morfológica que emplean algunas lenguas para actualizar o precisar la referencia de un sustantivo, transformándolo de desconocido y abstracto («un libro») a conocido y concreto («el libro»).'),
('Pronombre','Son palabras o morfemas cuyo referente no es fijo sino que se determina en relación con otras que normalmente ya se han nombrado.'),
('Verbo','Es la parte de la oración o categoría léxica que expresa acción, movimiento, existencia, consecución, condición o estado del sujeto.'),
('Adverbio','Es una parte de la oración que complementa a un verbo, un adjetivo, otros adverbios e incluso oraciones. Los adverbios expresan circunstancias, como pueden ser modo, lugar, tiempo, cantidad, afirmación, duda, etc., respondiendo a preguntas como ¿cuándo?, ¿dónde?, ¿cómo?, ¿de qué manera?, entre otras.'),
('Interjección','Es una clase de palabras de las lenguas naturales que no constituye una parte de la oración. Equivalen a oraciones que expresan un sentimiento vivo (¡ay!), una llamada enérgica (¡eh!) o describen elementalmente una acción (¡zas!, zigzag) sin ser léxica y gramaticalmente organizadas.'),
('Preposición','Es la clase de palabra invariable que introduce el llamado sintagma preposicional. Las preposiciones generalmente tienen la función de introducir adjuntos, y en ocasiones también complementos obligatorios ligando el nombre o sintagma nominal al que preceden inmediatamente con un verbo u otro nombre que las antecede.'),
('Conjunción','Es una palabra o conjunto de ellas que enlaza proposiciones, sintagmas o palabras. Constituye una de las clases de nexos.');

INSERT INTO subcategoria_gramatical (nombre, descripcion, categoria_gramatical_id) VALUES
('Sustantivo1','Son palabras cuyos referentes son clases de entidades fijas (a diferencia de los pronombres cuyos referentes son contextuales), no estados de hechos o relaciones gramaticales.',1),
('Sustantivo2','Son palabras cuyos referentes son clases de entidades fijas (a diferencia de los pronombres cuyos referentes son contextuales), no estados de hechos o relaciones gramaticales.',1),
('Sustantivo3','Son palabras cuyos referentes son clases de entidades fijas (a diferencia de los pronombres cuyos referentes son contextuales), no estados de hechos o relaciones gramaticales.',1),
('Adjetivo1','Es una parte de la oración o clase de palabra que complementa un sustantivo para calificarlo; expresa características o propiedades atribuidas a un sustantivo, ya sean concretas (perceptible por los sentidos, como en el libro grande o the big book) o abstractas (cognoscible por la mente, como en el libro difícil).',2),
('Adjetivo2','Es una parte de la oración o clase de palabra que complementa un sustantivo para calificarlo; expresa características o propiedades atribuidas a un sustantivo, ya sean concretas (perceptible por los sentidos, como en el libro grande o the big book) o abstractas (cognoscible por la mente, como en el libro difícil).',2),
('Adjetivo3','Es una parte de la oración o clase de palabra que complementa un sustantivo para calificarlo; expresa características o propiedades atribuidas a un sustantivo, ya sean concretas (perceptible por los sentidos, como en el libro grande o the big book) o abstractas (cognoscible por la mente, como en el libro difícil).',2),
('Artículo1','Es un tipo de determinante actualizador, una categoría morfológica que emplean algunas lenguas para actualizar o precisar la referencia de un sustantivo, transformándolo de desconocido y abstracto («un libro») a conocido y concreto («el libro»).',3),
('Artículo2','Es un tipo de determinante actualizador, una categoría morfológica que emplean algunas lenguas para actualizar o precisar la referencia de un sustantivo, transformándolo de desconocido y abstracto («un libro») a conocido y concreto («el libro»).',3),
('Adverbio1','Es una parte de la oración que complementa a un verbo, un adjetivo, otros adverbios e incluso oraciones. Los adverbios expresan circunstancias, como pueden ser modo, lugar, tiempo, cantidad, afirmación, duda, etc., respondiendo a preguntas como ¿cuándo?, ¿dónde?, ¿cómo?, ¿de qué manera?, entre otras.',6),
('Adverbio2','Es una parte de la oración que complementa a un verbo, un adjetivo, otros adverbios e incluso oraciones. Los adverbios expresan circunstancias, como pueden ser modo, lugar, tiempo, cantidad, afirmación, duda, etc., respondiendo a preguntas como ¿cuándo?, ¿dónde?, ¿cómo?, ¿de qué manera?, entre otras.',6),
('Preposición1','Es la clase de palabra invariable que introduce el llamado sintagma preposicional. Las preposiciones generalmente tienen la función de introducir adjuntos, y en ocasiones también complementos obligatorios ligando el nombre o sintagma nominal al que preceden inmediatamente con un verbo u otro nombre que las antecede.',8),
('Preposición2','Es la clase de palabra invariable que introduce el llamado sintagma preposicional. Las preposiciones generalmente tienen la función de introducir adjuntos, y en ocasiones también complementos obligatorios ligando el nombre o sintagma nominal al que preceden inmediatamente con un verbo u otro nombre que las antecede.',8),
('Conjunción1','Es una palabra o conjunto de ellas que enlaza proposiciones, sintagmas o palabras. Constituye una de las clases de nexos.',9);
