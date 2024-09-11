package api.intranet.responders;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HomeHTMLResponder {

    public ResponseEntity<String> response() {
        String body =
                //language=HTML
                """
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Présentation ADR</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .banner {
            background-color: #dbe7ff;
            padding: 30px;
            text-align: center;
            border-radius: 8px;
            margin: 20px;
        }
        .banner h1 {
            color: #333;
            font-size: 28px;
            margin: 0;
        }
        .content {
            margin: 20px;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        .content p {
            color: #666;
            line-height: 1.6;
        }
        .button-container {
            text-align: center;
            margin-top: 20px;
        }
        .next-button {
            background-color: #87bccf;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            border-radius: 5px;
            border: none;
            cursor: pointer;
        }
        .next-button:hover {
            background-color: #598da3;
        }
    </style>
</head>
<body>

    <div class="banner">
        <h1>Bienvenue sur la présentation ADR</h1>
    </div>

    <div class="content">
        <p>
            Le site n'est pas pété
        </p>
    </div>

    <div class="button-container">
        <button class="next-button" onclick="window.location.href='page.html?i=1'">Suivant</button>
    </div>

</body>
</html>
                """;

        return ResponseEntity.ok()
                .body(body);
    }
}
