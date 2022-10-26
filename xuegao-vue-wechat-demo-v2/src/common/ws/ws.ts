function initWebSocket(wsUrl: string): WebSocket {
  console.log("启动中");
  const ws: WebSocket = new WebSocket(wsUrl);
  console.log("initWebSocket new WebSocket");

  ws.onopen = function wsOnOpen(ev: Event) {
    console.log("wsOnOpen");
    console.log("wsOnOpen ev", ev);
    ws.send("我们的链接已经打开了");
  };
  console.log("initWebSocket wsOnOpen");

  ws.onmessage = function wsOnMsg(ev: MessageEvent) {
    console.log("wsOnMsg");
    console.log("wsOnMsg ev", ev);
  };
  console.log("initWebSocket wsOnMsg");

  ws.onerror = function wsOnError(ev: Event) {
    console.log("wsOnError");
    console.log("wsOnError ev", ev);
  };
  console.log("initWebSocket wsOnError");

  ws.onclose = function wsOnClose(ev: CloseEvent) {
    console.log("wsOnClose");
    console.log("wsOnClose ev", ev);
  };
  console.log("initWebSocket wsOnClose");

  console.log("ws = ", ws);

  return ws;
}
