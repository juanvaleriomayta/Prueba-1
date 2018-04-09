package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import model.model;
import org.json.JSONObject;

public class dao {

    public model consultarDni(model dl) throws org.json.JSONException, IOException {

        //Crea es json de Solicitud
        JSONObject obj = new JSONObject();
        obj.put("dni", dl.getDni());

        //Realiza la consulta
        String json = obj.toString();
        URL url = new URL("https://tecactus.com/api/reniec/dni");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("X-RateLimit-Limit", "100");
        con.setRequestProperty("X-RateLimit-Remaining", "58");
        con.setRequestProperty("Authorization", "Bearer "+dl.getTokendni());
        con.setDoOutput(true);
        con.getOutputStream().write(json.getBytes("UTF-8"));
        Reader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

        //Trae la cadene de respuesta
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;) {
            sb.append((char) c);
        }
        String response = sb.toString(); //String Respuesta
        System.out.println(response);
        JSONObject json2 = new JSONObject(response); //JSON con la respuesta

        //Contenido del json rellenando en cada modelo
        dl.setNombres((String) json2.get("nombres"));
        dl.setApellidosPaterno((String) json2.get("apellido_paterno"));
        dl.setApellidoMaterno((String) json2.get("apellido_materno"));
        dl.setCaracterVer((String) json2.get("caracter_verificacion"));
        dl.setCaracterVerAnte((String) json2.get("caracter_verificacion_anterior"));
        return dl;
    }

    public model consultarRuc(model dl) throws org.json.JSONException, IOException {

        //Crea es json de Solicitud
        JSONObject obj = new JSONObject();
        obj.put("ruc", dl.getRuc());
        obj.put("token", dl.getTokenruc());

        //Realiza la consulta
        String json = obj.toString();
        URL url = new URL("https://ruc.com.pe/api/v1/ruc");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        con.getOutputStream().write(json.getBytes("UTF-8"));
        Reader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

        //Trae la cadene de respuesta
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;) {
            sb.append((char) c);
        }
        String response = sb.toString(); //String Respuesta

        JSONObject json2 = new JSONObject(response); //JSON con la respuesta

        //Contenido del json rellenando en cada modelo
        dl.setNombre_o_razon_social((String) json2.get("nombre_o_razon_social"));
        dl.setEstado_del_contribuyente((String) json2.get("estado_del_contribuyente"));
        dl.setCondicion_de_domicilio((String) json2.get("condicion_de_domicilio"));
        dl.setUbigeo((String) json2.get("ubigeo"));
        dl.setTipo_de_via((String) json2.get("tipo_de_via"));
        dl.setNombre_de_via((String) json2.get("nombre_de_via"));
        dl.setCodigo_de_zona((String) json2.get("codigo_de_zona"));
        dl.setTipo_de_zona((String) json2.get("tipo_de_zona"));
        dl.setNumero((String) json2.get("numero"));
        dl.setInterior((String) json2.get("interior"));
        dl.setLote((String) json2.get("lote"));
        dl.setDpto((String) json2.get("dpto"));
        dl.setManzana((String) json2.get("manzana"));
        dl.setKilometro((String) json2.get("kilometro"));
        dl.setDepartamento((String) json2.get("departamento"));
        dl.setProvincia((String) json2.get("provincia"));
        dl.setDistrito((String) json2.get("distrito"));
        dl.setDireccion((String) json2.get("direccion"));
        dl.setDireccion_completa((String) json2.get("direccion_completa"));
        dl.setUltima_actualizacion((String) json2.get("ultima_actualizacion"));
        return dl;
    }


}
