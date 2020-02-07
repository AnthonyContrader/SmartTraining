import { AbstractService } from './abstractservice';
import { BotDTO } from 'src/dto/botdto';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

export class BotService extends AbstractService<BotDTO>{

    port: string= '8080';

    constructor(http: HttpClient){
        super(http);
        this.type = 'bot';
    }

    makeQuest(question: String): Observable<any> {
        return this.http.get<any>('http://localhost:' + this.port + '/' + this.type + '/setQuestion?question=' + question);
    }

}