Python 3.14.2 (tags/v3.14.2:df79316, Dec  5 2025, 17:18:21) [MSC v.1944 64 bit (AMD64)] on win32
Enter "help" below or click "Help" above for more information.
>>> import numpy as np
... import pandas as pd
... import matplotlib.pyplot as plt
... from sklearn.model_selection import train_test_split
... from sklearn.linear_model import LinearRegression
... from sklearn.metrics import mean_absolute_error, mean_squared_error, r2_score
... 
... # 1. Generate Synthetic Housing Data
... np.random.seed(42)
... n_samples = 500
... 
... data = {
...     'Square_Footage': np.random.randint(1000, 4000, n_samples),
...     'Bedrooms': np.random.randint(2, 6, n_samples),
...     'Age_Years': np.random.randint(0, 40, n_samples)
... }
... 
... df = pd.DataFrame(data)
... 
... # Define a true price function with some random noise (simulating market variance)
... # Base price: $50,000 | $150 per sqft | $25,000 per bedroom | -$1,200 per year of age
... noise = np.random.normal(0, 15000, n_samples)
... df['Price'] = 50000 + (df['Square_Footage'] * 150) + (df['Bedrooms'] * 25000) - (df['Age_Years'] * 1200) + noise
... 
... # 2. Split into Features (X) and Target Variable (y)
... X = df[['Square_Footage', 'Bedrooms', 'Age_Years']]
... y = df['Price']
... 
... # Split data: 80% for training and 20% for testing
... X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
... 
... # 3. Train the Linear Regression Model
... model = LinearRegression()
... model.fit(X_train, y_train)
... 
... # 4. Evaluate Model Performance
... y_pred = model.predict(X_test)
... 
... mae = mean_absolute_error(y_test, y_pred)
... mse = mean_squared_error(y_test, y_pred)
... rmse = np.sqrt(mse)
... r2 = r2_score(y_test, y_pred)
... 
... print("--- Model Performance Metrics ---")
... print(f"Mean Absolute Error (MAE): ${mae:,.2f}")
... print(f"Root Mean Squared Error (RMSE): ${rmse:,.2f}")
... print(f"R-squared Score (R²): {r2:.4f}\n")
... 
... print("--- Model Coefficients (Weights) ---")
... print(f"Baseline Intercept: ${model.intercept_:,.2f}")
... for feature, coef in zip(X.columns, model.coef_):
    print(f"{feature}: ${coef:,.2f} change per unit")

# 5. Predict Price for a Custom House
# Example: 2,500 sqft, 4 bedrooms, 10 years old
custom_house = pd.DataFrame([[2500, 4, 10]], columns=['Square_Footage', 'Bedrooms', 'Age_Years'])
predicted_price = model.predict(custom_house)

print(f"\n--- Custom Prediction ---")
print(f"Predicted Price for a 2,500 sqft, 4-bed, 10-year-old house: ${predicted_price[0]:,.2f}")
