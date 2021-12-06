package com.tienda.bendicion.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.bendicion.model.DetalleVenta;
import com.tienda.bendicion.repository.DetalleVentasRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DetallVentaController {

	@Autowired
	DetalleVentasRepository dventaRepository;

	@GetMapping("/detalleventas")
	public ResponseEntity<List<DetalleVenta>> getAllDetalleVentas(
			@RequestParam(required = false) Integer codigodetalleventa) {
		try {
			List<DetalleVenta> dventas = new ArrayList<DetalleVenta>();

			if (codigodetalleventa == null) {
				dventaRepository.findAll().forEach(dventas::add);
			} else {
				dventaRepository.findByCodigodetalleventa(codigodetalleventa).forEach(dventas::add);
			}

			if (dventas.isEmpty()) {
				// error 204
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			// error 201
			return new ResponseEntity<>(dventas, HttpStatus.OK);
		} catch (Exception e) {
			// error 500
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getcodigoventas/{codigoventa}")
	public ResponseEntity<List<DetalleVenta>> getVentasByCedula(@PathVariable("codigoventa") Integer codigoventa) {

		try {
			System.out.println(codigoventa);
			List<DetalleVenta> dventas = dventaRepository.findByCodigoventa(codigoventa);

			if (dventas.isEmpty()) {
				// no encontre info
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			// encontre info
			return new ResponseEntity<>(dventas, HttpStatus.OK);
		} catch (Exception e) {
			// error algo paso
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/detalleventas")
	public ResponseEntity<DetalleVenta> createVentas(@RequestBody DetalleVenta dvent) {
		try {
			DetalleVenta _dventa = dventaRepository.save(new DetalleVenta(dvent.getCodigodetalleventa(),
					dvent.getCantidadproducto(), dvent.getCodigoproducto(), dvent.getCodigoventa(),
					dvent.getValortotal(), dvent.getValorventa(), dvent.getValoriva()));
			// si lo cree guardo en 200
			return new ResponseEntity<>(_dventa, HttpStatus.CREATED);
		} catch (Exception e) {
			// sino lo pude crear error 500
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/detalleventas/{id}")
	public ResponseEntity<DetalleVenta> updateDetalleVentas(@PathVariable("id") String id,
			@RequestBody DetalleVenta dvent) {
		Optional<DetalleVenta> dventaData = dventaRepository.findById(id);

		if (dventaData.isPresent()) {
			DetalleVenta _dventa = dventaData.get();
			_dventa.setCodigodetalleventa(dvent.getCodigodetalleventa());
			_dventa.setCantidadproducto(dvent.getCantidadproducto());
			_dventa.setCodigoproducto(dvent.getCodigoproducto());
			_dventa.setCodigoventa(dvent.getCodigoventa());
			_dventa.setValortotal(dvent.getValortotal());
			_dventa.setValorventa(dvent.getValorventa());
			_dventa.setValoriva(dvent.getValoriva());
			return new ResponseEntity<>(dventaRepository.save(_dventa), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/detalleventas/{id}")
	public ResponseEntity<HttpStatus> deleteDetalleVentas(@PathVariable("id") String id) {
		try {
			dventaRepository.deleteById(id);
			// si lo borre, retorno 200
			System.out.println(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// sino lo borre, retorno 500
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/detalleventas")
	public ResponseEntity<HttpStatus> deleteAllVentass() {
		try {
			dventaRepository.deleteAll();
			// si los borre todos 201
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// sino los borre todos 500
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
