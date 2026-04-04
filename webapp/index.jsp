<!DOCTYPE html>
<html>
<head>
    <title>Service Marketplace</title>

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f8fb; /* very light pastel blue */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: white;
            padding: 40px 50px;
            border-radius: 12px;
            text-align: center;
            box-shadow: 0 8px 20px rgba(0,0,0,0.08);
            width: 320px;
        }

        h1 {
            color: #4a90a4; /* pastel blue shade */
            margin-bottom: 25px;
            font-weight: 500;
        }

        button {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            background-color: #a8d0e6; /* second pastel blue */
            color: #033b4a;
            transition: 0.2s;
        }

        button:hover {
            background-color: #8fc3db;
        }

        .footer {
            margin-top: 15px;
            font-size: 12px;
            color: #777;
        }
    </style>
</head>

<body>

    <div class="container">
        <h1>Service Marketplace</h1>

        <a href="views/login.html">
            <button>Login</button>
        </a>

        <a href="views/register.html">
            <button>Register</button>
        </a>

        <div class="footer">
            Multi-Client Platform
        </div>
    </div>

</body>
</html>