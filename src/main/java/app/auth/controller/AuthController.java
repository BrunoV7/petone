package app.auth.controller;
import app.auth.models.AuxToken;
import app.auth.models.Login;
import app.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login){
            String mensagem = this.authService.login(login);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
    }

    @PostMapping("/login/test")
    public ResponseEntity<AuxToken> loginTest(@RequestBody Login login){
        return new ResponseEntity<>(this.authService.Test(), HttpStatus.CREATED);
    }

}
