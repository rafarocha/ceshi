ceshi
Projeto de trabalho para curso de testes de unidade e integração

...
Formatações de código para slides
# highlight http://www.andre-simon.de/doku/highlight/en/highlight.php
...

Comandos usados para geração do codigo nos slides com projeto Highlight

	exemplos:
		# highlight -O rtf Moviment.java | pbcopy
		# highlight -O rtf Moviment.java --line-numbers -w Breeze --src-lang java | pbcopy
		# highlight -O rtf Calculadora.java --line-numbers --font-size 24 --font Inconsolata --style fine_blue -W -J 50 -j 3 --src-lang java | pbcopy
		# highlight -O rtf SevenErrosCodeSmells.java --line-numbers --font-size 24 --font 'Designer Notes' --style anotherdark -W -J 50 -j 3 --src-lang java | pbcopy
	
	obs: é necessário estar no diretório corrente do projeto para encontrar o arquivo
	
	usando:
		highlight -O rtf anotacoes_sintaxe.snippet --line-numbers --font-size 40 --font 'Designer Notes' --style anotherdark -W -J 60 -j 3 --src-lang java | pbcopy

...
flyway já está configurado via maven
para testar execute o comando e pronto!
...
mvn compile flyway:migrate
...

para ver a base, inicie o h2 e coloque a seguinte url abaixo:    
jdbc:h2:~/<diretorio_raiz_projeto>/target/h2 (recomendado)
jdbc:h2:~/Documents/workspace/curso/ceshi/target/h2 (exemplo minha maquina)
