Feature: Credit Assessment Calculator

  Scenario Outline: Calculate Credit Assessment Score
    When The calculateCreditAssessmentScore API is called with parameters <numberOfEmployees>, "<companyType>", <numberOfYearsOperated>
    Then The credit assessment score should match <result>

    Examples:

      | numberOfEmployees | companyType | numberOfYearsOperated | result |
      | 2 | Sole Proprietorship | 5 | 40 |
      | 6 | Sole Proprietorship | 5 | 60 |
      | 12 | Sole Proprietorship | 5 | 72 |
      | 15 | Sole Proprietorship | 5 | 95 |
      | 20 | Sole Proprietorship | 5 | 95 |
      | 6 | Sole Proprietorship | 0 | 32 |
      | 6 | Sole Proprietorship | 4 | 60 |
      | 6 | Sole Proprietorship | 10 | 68 |
      | 6 | Sole Proprietorship | 16 | 91 |
      | 2 | Limited Liability Company | 5 | 91 |
      | 6 | Limited Liability Company | 5 | 111 |
      | 12 | Limited Liability Company | 5 | 123 |
      | 15 | Limited Liability Company | 5 | 146 |
      | 20 | Limited Liability Company | 5 | 146 |
      | 6 | Limited Liability Company | 0 | 83 |
      | 6 | Limited Liability Company | 4 | 111 |
      | 6 | Limited Liability Company | 10 | 119 |
      | 6 | Limited Liability Company | 16 | 142 |
      | 2 | Partnership | 5 | 103 |
      | 6 | Partnership | 5 | 123 |
      | 12 | Partnership | 5 | 135 |
      | 15 | Partnership | 5 | 158 |
      | 20 | Partnership | 5 | 158 |
      | 6 | Partnership | 0 | 95 |
      | 6 | Partnership | 4 | 123 |
      | 6 | Partnership | 10 | 131 |
      | 6 | Partnership | 16 | 154 |
      | 2 | Others | 5 | 28 |
      | 6 | Others | 5 | 48 |
      | 12 | Others | 5 | 60 |
      | 15 | Others | 5 | 83 |
      | 20 | Others | 5 | 83 |
      | 6 | Others | 0 | 20 |
      | 6 | Others | 4 | 48 |
      | 6 | Others | 10 | 56 |
      | 6 | Others | 16 | 79 |
      | 2 | SoleProprietorship | 5 | 0 |
      | -6 | Sole Proprietorship | 5 | 0 |
      | 12 | Sole Proprietorship | -5 | 0 |
      | 2 | Limited Company | 5 | 0 |
      | -6 | Limited Liability Company | 5 | 0 |
      | 12 | Limited Liability Company | -5 | 0 |
      | 2 | Partners | 5 | 0 |
      | -6 | Partnership | 5 | 0 |
      | 12 | Partnership | -5 | 0 |
      | 2 | Other | 5 | 0 |
      | -6 | Others | 5 | 0 |
      | 12 | Others | -5 | 0 |