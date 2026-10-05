<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html><html lang="vi"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Simple Calculator</title>
<style>body{font-family:Arial,sans-serif;margin:0;min-height:100vh;display:grid;place-items:center;background:#f8fafc}main{width:min(380px,80vw);padding:30px;background:white;border-radius:12px;box-shadow:0 4px 16px #0001}h1{font-size:24px;color:#1b2a7a}label{display:block;margin-top:16px}input,select,button{box-sizing:border-box;width:100%;padding:12px;margin-top:6px;border:1px solid #ccc;border-radius:6px}button{margin-top:22px;background:#1b2a7a;color:white;cursor:pointer}</style></head>
<body><main><h1>Simple Calculator</h1><form action="calculate" method="POST">
<label for="first">Toán hạng thứ nhất</label><input id="first" name="firstOperand" type="number" step="any" required>
<label for="operator">Toán tử</label><select id="operator" name="operator"><option value="+">Cộng (+)</option><option value="-">Trừ (−)</option><option value="*">Nhân (×)</option><option value="/">Chia (÷)</option></select>
<label for="second">Toán hạng thứ hai</label><input id="second" name="secondOperand" type="number" step="any" required>
<button type="submit">Calculate</button></form></main></body></html>
