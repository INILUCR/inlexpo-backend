INSERT INTO diccionario (nombre, descripcion, tipo) VALUES
('Diccionario de la lengua española', 'El Diccionario de la lengua española es el resultado de la colaboración de todas las academias, cuyo propósito es recoger el léxico general utilizado en España y en los países hispánicos. Se dirige, fundamentalmente, a hablantes cuya lengua materna es el español, quienes encontrarán en él recursos suficientes para descifrar textos escritos y orales.', 'Normativo'),
('Diccionario de uso del español', 'Para guiar en el uso del español tanto a los que lo tienen como idioma propio como a aquellos que lo aprenden y han llegado en el conocimiento de él a ese punto en que el diccionario bilingüe puede y debe ser sustituido por el diccionario en el propio idioma que se aprende. Y ello, en primer lugar, trayendo a la mano del usuario todos los recursos de que el idioma dispone para nombrar una cosa, para expresar una idea con la máxima precisión o para realizar verbalmente cualquier acto expresivo. Y, en segundo lugar, resolviendo sus dudas acerca de la legitimidad o ilegitimidad de una expresión, de la manera correcta de resolver cierto caso de construcción, etc.', 'De uso práctico');

INSERT INTO categoria_gramatical (nombre, descripcion, abreviatura, diccionario_id) VALUES
('Sustantivo','Son palabras cuyos referentes son clases de entidades fijas (a diferencia de los pronombres cuyos referentes son contextuales), no estados de hechos o relaciones gramaticales.', 'sust', 1),
('Adjetivo','Es una parte de la oración o clase de palabra que complementa un sustantivo para calificarlo; expresa características o propiedades atribuidas a un sustantivo, ya sean concretas (perceptible por los sentidos, como en el libro grande o the big book) o abstractas (cognoscible por la mente, como en el libro difícil).', 'adj', 1),
('Artículo','Es un tipo de determinante actualizador, una categoría morfológica que emplean algunas lenguas para actualizar o precisar la referencia de un sustantivo, transformándolo de desconocido y abstracto («un libro») a conocido y concreto («el libro»).', 'art', 1),
('Pronombre','Son palabras o morfemas cuyo referente no es fijo sino que se determina en relación con otras que normalmente ya se han nombrado.', 'pron', 1),
('Verbo','Es la parte de la oración o categoría léxica que expresa acción, movimiento, existencia, consecución, condición o estado del sujeto.', 'vrb', 1),
('Adverbio','Es una parte de la oración que complementa a un verbo, un adjetivo, otros adverbios e incluso oraciones. Los adverbios expresan circunstancias, como pueden ser modo, lugar, tiempo, cantidad, afirmación, duda, etc., respondiendo a preguntas como ¿cuándo?, ¿dónde?, ¿cómo?, ¿de qué manera?, entre otras.', 'advrb', 1),
('Interjección','Es una clase de palabras de las lenguas naturales que no constituye una parte de la oración. Equivalen a oraciones que expresan un sentimiento vivo (¡ay!), una llamada enérgica (¡eh!) o describen elementalmente una acción (¡zas!, zigzag) sin ser léxica y gramaticalmente organizadas.', 'intr', 1),
('Preposición','Es la clase de palabra invariable que introduce el llamado sintagma preposicional. Las preposiciones generalmente tienen la función de introducir adjuntos, y en ocasiones también complementos obligatorios ligando el nombre o sintagma nominal al que preceden inmediatamente con un verbo u otro nombre que las antecede.', 'prep', 1),
('Conjunción','Es una palabra o conjunto de ellas que enlaza proposiciones, sintagmas o palabras. Constituye una de las clases de nexos.', 'conj', 1);

INSERT INTO articulo (lema, diccionario_id) VALUES
('academia',1),
('bracear',1);

INSERT INTO acepcion (definicion, prioridad, articulo_id, categoria_gramatical_id) VALUES
('Sociedad científica, literaria o artística establecida con autoridad pública.',1,1,1),
('Junta o reunión de los académicos.',2,1,1),
('Casa donde los académicos tienen sus juntas.',3,1,1),
('Mover repetidamente los brazos, por lo común con esfuerzo o gallardía.',1,2,5),
('Nadar sacando los brazos fuera del agua y volteándolos hacia adelante.',2,2,5),
('Esforzarse, forcejear.',3,2,5);