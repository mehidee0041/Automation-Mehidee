const http = require('http');
const fs = require('fs');
const path = require('path');

const server = http.createServer((req, res) => {
    if (req.url === '/' || req.url === '/index.html') {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end(`
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bongo Test Automation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        .description {
            background: #e8f4f8;
            padding: 20px;
            border-left: 4px solid #2196F3;
            margin: 20px 0;
        }
        .file-list {
            background: #f9f9f9;
            padding: 15px;
            border-radius: 4px;
            margin: 20px 0;
        }
        .file {
            padding: 8px 0;
            border-bottom: 1px solid #eee;
        }
        .file:last-child {
            border-bottom: none;
        }
        code {
            background: #f4f4f4;
            padding: 2px 6px;
            border-radius: 3px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🤖 Bongo Test Automation Project</h1>
        
        <div class="description">
            <h3>Project Overview</h3>
            <p>This is a Java-based Selenium web automation project for testing BongoBD website functionality, specifically user registration and SMS verification processes.</p>
        </div>

        <h3>Java Test Classes</h3>
        <div class="file-list">
            <div class="file">
                <strong>LoginBongo.java</strong> - Main test class for user registration with SMS verification
            </div>
            <div class="file">
                <strong>ClickArbitraryContent.java</strong> - Test class for link clicking functionality
            </div>
            <div class="file">
                <strong>ut.java</strong> - Utility class for SMS handling using smsreceivefree.com
            </div>
        </div>

        <h3>Dependencies</h3>
        <div class="file-list">
            <div class="file">
                <code>Twilio SDK 7.37.0</code> - For SMS functionality
            </div>
            <div class="file">
                <code>JSoup 1.11.3</code> - For HTML parsing
            </div>
            <div class="file">
                <code>Selenium WebDriver</code> - For browser automation
            </div>
        </div>

        <h3>To Run Tests</h3>
        <div class="description">
            <p>Since this is a Java Maven project, use the following commands in the <code>bongo</code> directory:</p>
            <p><code>mvn clean compile</code> - Compile the project</p>
            <p><code>mvn exec:java -Dexec.mainClass="TestPack.LoginBongo"</code> - Run login test</p>
            <p><code>mvn exec:java -Dexec.mainClass="TestPack.ClickArbitraryContent"</code> - Run click test</p>
        </div>
    </div>
</body>
</html>
        `);
    } else {
        res.writeHead(404, { 'Content-Type': 'text/html' });
        res.end('<h1>404 - Page Not Found</h1>');
    }
});

const PORT = 3000;
server.listen(PORT, () => {
    console.log(\`Server running at http://localhost:\${PORT}/\`);
});