export interface Book {
  bkid?: number;
  bkname: string;
  bkauth: string;
  genre: string;

  quantity: number;
  totalQuantity: number;   // now required, since backend always has it
  available: boolean;

  borrowDate?: string;     // LocalDate → string in JSON
  returnDate?: string;     // LocalDate → string in JSON
  borrowedBy?: string;
}
