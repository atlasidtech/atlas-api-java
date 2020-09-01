#### Atlas API Intermediate Class

Sebelum menjalankan automation, teman - teman jalankan dulu aplikasi backend di komputer kalian masing - masing. Caranya dengan membuka terminal lalu arahkan terminal folder `backend` dan jalankan command:

` java -jar student-rest-api.jar -Dapplication.properties = application.properties`

Teman - teman juga bisa import postman collection yang sudah disediakan didalam project ini. nama file postman collectionnya `atlas.id.postman_collection.json` (didalam folder backend). Untuk cara importnya ke postman bisa pakai link ini:
 
 `https://learning.postman.com/docs/getting-started/importing-and-exporting-data/#importing-postman-data`
 
 Untuk menjalankan API automation, teman - teman bisa membuka file `ApiJavaAutomationTest.java` lalu pencet tombol play dari sana. Bisa juga dengan command line:
 
 ` ./gradlew clean test`    
 
 