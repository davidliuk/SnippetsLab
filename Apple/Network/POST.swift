func makeUpdateCountSheet() {
 // 这里直接使用 jsonString 转成字典，然后转成 Data，将流放到 request的 httpBody中， 模拟发送一个http请求
    let jsonString = "{\"Data\":{\"xxx\":\"834\",\"xxx\":[{\"xxx\":[{\"xxx\":\"031019\",\"xxx\":\"ADD\",\"xxx\":\"9\"},{\"xxx\":\"5651G-06920ADBAA\",\"xxx\":\"ADD\",\"xxx\":\"6\"}],\"xxx\":\"xxx\",\"Counted\":true,\"xxx\":true,\"LineNum\":\"1\",\"xxx\":\"235\",\"Quantity\":\"15\"}],\"xxx\":\"\",\"Initials\":\"we\",\"xxx\":true},\"xxx\":\"\"}"
    let dict = self.getDictionaryFromJSONString(jsonString: jsonString)
    print(dict)
    var  jsonData = NSData()
    do {
         jsonData = try JSONSerialization.data(withJSONObject: dict, options: .prettyPrinted) as NSData
    } catch {
        print(error.localizedDescription)
    }
 // 构建URL
    let url:URL = URL(string: "https://xxx/xxx/API?xxx")!
    // session
    let session = URLSession.shared
    // request
    var request = URLRequest(url: url)
    request.httpMethod = "POST"
    // 设置Content-Length，非必须
    request.setValue("\(jsonData.length)", forHTTPHeaderField: "Content-Length")
    // 设置 Content-Type 为 json 类型
    request.setValue("application/json", forHTTPHeaderField: "Content-Type")
    // POST 请求将 数据 放置到 请求体中
    request.httpBody = jsonData as Data
    // 发送请求
    let task = session.dataTask(with: request as URLRequest) {(
        data, response, error) in

        guard let data = data, let _:URLResponse = response, error == nil else {
            print("error")
            return
        }
        // 返回值 utf8 转码
        let dataString =  String(data: data, encoding: String.Encoding.utf8)
        // 将 jsonString 转成字典
        let dict = self.getDictionaryFromJSONString(jsonString: dataString!)
        print(dict)
    }
    task.resume()
}