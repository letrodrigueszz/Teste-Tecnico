import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserDTO } from '../models/user.dto';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = '/api/users'; // Adjust the API URL as needed

  constructor(private http: HttpClient) { }

  getUsers(): Observable<UserDTO[]> {
    return this.http.get<UserDTO[]>(this.apiUrl);
  }

  getUser(id: number): Observable<UserDTO> {
    return this.http.get<UserDTO>(`${this.apiUrl}/${id}`);
  }

  createUser(user: UserDTO): Observable<UserDTO> {
    return this.http.post<UserDTO>(this.apiUrl, user);
  }

  updateUser(id: number, user: UserDTO): Observable<UserDTO> {
    return this.http.put<UserDTO>(`${this.apiUrl}/${id}`, user);
  }

  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
