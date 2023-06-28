using System;
using System.IO;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Azure.WebJobs;
using Microsoft.Azure.WebJobs.Extensions.Http;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Logging;
using Newtonsoft.Json;
using JsonFlatten;
using Newtonsoft.Json.Linq;
using System.Net.Http;
namespace powerBI_POS
{
    public static class PowerBIVibPOS
    {
        [FunctionName("PowerBI-Vib-POS")]
        public static async Task<IActionResult> Run(
            [HttpTrigger(AuthorizationLevel.Function, "get", "post", Route = null)] HttpRequest req,
            ILogger log)
        {
            log.LogInformation("C# HTTP trigger function processed a request.");
            string name = req.Query["name"];
            string requestBody = await new StreamReader(req.Body).ReadToEndAsync();
            var jObject = JObject.Parse(requestBody);
            var flattened = jObject.Flatten();
            var flattenedJsonString = JsonConvert.SerializeObject(flattened, Formatting.Indented);
            Console.WriteLine(flattenedJsonString);
            log.LogInformation(flattenedJsonString);
            String powerBiurl = Environment.GetEnvironmentVariable("PowerBIPOSURL");
            HttpClient client = new HttpClient();
            HttpContent content = new StringContent("[" + flattenedJsonString + "]");
            HttpResponseMessage response = await client.PostAsync(powerBiurl, content);
            response.EnsureSuccessStatusCode();
            log.LogInformation(response.ToString());
            return new OkObjectResult(response);
        }
    }
}