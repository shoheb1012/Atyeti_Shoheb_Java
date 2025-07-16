✅ Problem Statement: Financial Transaction File Validator
📘 Background:
Your organization receives daily financial transaction files from multiple clients via a secure upload system. Each client must follow specific naming conventions and data formats. Your job is to implement a File Validation Processor that validates:
File Name Pattern (to avoid wrong/malicious uploads)
File Content/Structure
Field-level Data Validations
🔍 Input:
Files are uploaded to a specific directory.
Each file is a .csv file named as:

Example:
File content format (CSV):
🎯 Objectives:
File Name Validation
Must match the pattern: ^[A-Z0-9]{3,}_TXN_\d{8}\.csv$
The date (yyyyMMdd) in the filename should match the current date or a configured allowed date.

File Content Validation
CSV file must have a valid header as shown above.
Each row must have exactly 6 columns.
No field should be empty.

Field-Level Validation
TXN_ID: Must be alphanumeric and unique in file.
ACCOUNT_NO: Must be 10-digit numeric.
TXN_DATE: Must be a valid date in yyyy-MM-dd format, and match the date in the filename.
AMOUNT: Must be a positive decimal number.
CURRENCY: Must be one of the allowed values (e.g., INR, USD, EUR).
STATUS: Must be one of SUCCESS, FAILED, or PENDING.
Error Reporting
For each file, generate a validation report:
If valid, move to validated/ directory.
If invalid, move to rejected/ directory with a .errors.txt file describing the issues.
🧪 Example Valid File Name:
CopyEditXYZ789_TXN_20250701.csv
❌ Example Invalid File Names:
xyz789_txn_20250701.csv (lowercase)
XYZ789_TXNS_20250701.csv (wrong keyword)
XYZ789_TXN_2025071.csv (wrong date format)
🧩 Example Invalid Content (Issues marked):
javaCopyEditTXN_ID,ACCOUNT_NO,TXN_DATE,AMOUNT,CURRENCY,STATUS
TXN001,1234567890,2025-07-01,1200.50,INR,SUCCESS
TXN002,987654321,2025-07-01,100.00,USD,FAILED       ← Invalid ACCOUNT_NO (9 digits)
TXN003,1234567890,2025-07-02,500.00,EUR,APPROVED    ← Invalid STATUS
🛠️ Optional Enhancements:
Use a config file to load valid currencies and status codes.
Maintain an audit log for each processed file.
Add support for scheduling (validate every hour/day automatically).
Support .zip files containing multiple CSVs.
TXN_ID,ACCOUNT_NO,TXN_DATE,AMOUNT,CURRENCY,STATUS
TXN001,1234567890,2025-07-01,1200.50,INR,SUCCESS...
ABC123_TXN_20250701.csv
 