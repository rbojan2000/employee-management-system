
export interface User {
  name: string;
  surname: string;
  re_password: string;
  email: string;
  password: string;
  address: Address | null;
}

export interface Address {
  street: string,
  city: string,
  state: string,
}
